package com.knightein.knuc;

import cloud.commandframework.annotations.AnnotationParser;
import cloud.commandframework.execution.AsynchronousCommandExecutionCoordinator;
import cloud.commandframework.meta.SimpleCommandMeta;
import cloud.commandframework.paper.PaperCommandManager;
import com.knightein.knuc.command.PlayerCommands;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.function.Function;

public final class KNUC extends JavaPlugin {
    private static KNUC instance;

    public static KNUC getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        try {
            PaperCommandManager<CommandSender> commandManager = new PaperCommandManager<>(
                    this,
                    AsynchronousCommandExecutionCoordinator.<CommandSender>builder().build(),
                    Function.identity(),
                    Function.identity()
            );

            AnnotationParser<CommandSender> parser = new AnnotationParser<>(
                    commandManager,
                    CommandSender.class,
                    p -> SimpleCommandMeta.empty()
            );

            // All new commands go down here
            parser.parse(new PlayerCommands());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {

    }
}
