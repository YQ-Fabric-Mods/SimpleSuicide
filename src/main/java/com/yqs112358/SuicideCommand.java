package com.yqs112358;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

import static net.minecraft.server.command.CommandManager.*;


public final class SuicideCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher){
        dispatcher.register(literal("suicide")
                .executes(ctx -> playerSuicide(ctx.getSource())));
    }

    public static int playerSuicide(ServerCommandSource source) throws CommandSyntaxException {
        ServerPlayerEntity player = source.getPlayerOrThrow();
        player.damage(player.getDamageSources().playerAttack(player), Float.MAX_VALUE);
        return Command.SINGLE_SUCCESS; // 成功
    }
}
