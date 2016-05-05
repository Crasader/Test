/*
 * StateManager.cpp
 *
 *   Created on: 2014��11��9��
 *      Author: Administrator
 */

#include "StateManager.h"

static StateManager* instance;

StateManager::StateManager() {
}

StateManager::~StateManager() {
}

StateManager* StateManager::getInstance(){
	if(!instance){
		instance=new StateManager();
	}
	return instance;
}

void StateManager::setGameState(GameState* state){
	if(currState){
		delete currState;
	}
	currState=state;
}
