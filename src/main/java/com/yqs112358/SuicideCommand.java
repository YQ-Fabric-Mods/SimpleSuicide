package com.yqs112358;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerPlayer;

import static net.minecraft.commands.Commands.literal;


public final class SuicideCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher){
        dispatcher.register(literal("suicide")
                .executes(ctx -> playerSuicide(ctx.getSource())));
    }

    public static int playerSuicide(CommandSourceStack source) throws CommandSyntaxException {
        ServerPlayer player = source.getPlayerOrException();
        player.kill(player.level());
        return Command.SINGLE_SUCCESS;
    }
}
