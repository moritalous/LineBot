package com.sample.linebot.mybot.sendmessage;

import com.sample.linebot.api.receivemessage.Result;

public interface IMyBot {

	boolean match(Result result);

	void execute(Result result);

	String keyword();

	String descryption();
}
