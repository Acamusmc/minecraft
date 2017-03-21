package com.shepherdjerred.riotportals.messages;


public class GenericMessages {

	public static String getReloadMessage() {

		return MessageHelper.getMessagePrefix() + MessageHelper.colorMessagesString("generic.reload");

	}

	public static String getNoPermsMessage() {

		return MessageHelper.getMessagePrefix() + MessageHelper.colorMessagesString("generic.noPerms");

	}

	public static String getNoConsoleMessage() {

		return MessageHelper.getMessagePrefix() + MessageHelper.colorMessagesString("generic.noConsole");

	}

	public static String getNoArgsMessage(String correctArgs) {

		return MessageHelper.getMessagePrefix() + MessageHelper.colorMessagesString("generic.noArgs.correct").replace("%args%", correctArgs);

	}

	public static String getInvalidArgsMessage(String givenArg, String correctArgs) {

		return MessageHelper.getMessagePrefix() + MessageHelper.colorMessagesString("generic.invalidArg.correct").replace("%arg%", givenArg).replace("%args%", correctArgs);

	}
	
}
