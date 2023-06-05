package com.in28minutes.learnspringframework02.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
public class SuperContraGame implements GamingConsole {

	@Override
	public void up() {
		System.out.println("Super Contra: Up");
	}

	@Override
	public void down() {
		System.out.println("Super Contra: Down");
	}

	@Override
	public void left() {
		System.out.println("Super Contra: Left");
	}

	@Override
	public void right() {
		System.out.println("Super Contra: Right");
	}

}
