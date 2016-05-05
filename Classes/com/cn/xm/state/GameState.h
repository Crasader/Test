/*
 * GameState.h
 *
 *  Created on: 2014年11月9日
 *      Author: Administrator
 */

#ifndef GAMESTATE_H_
#define GAMESTATE_H_

class GameState{
public:
	GameState();
	virtual ~GameState();

public:
	void init();
	void enter();
	void exit();
};

#endif /* GAMESTATE_H_ */
