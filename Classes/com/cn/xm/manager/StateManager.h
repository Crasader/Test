/*
 * StateManager.h
 *
 *   Created on: 2014年11月9日
 *      Author: Administrator
 */

#ifndef STATEMANAGER_H_
#define STATEMANAGER_H_

/**
 *游戏状态机管理器
 *游戏的状态流程：GS_First-》GS_UpdatePackage-》GS_Logo(public notice)-》
 *游戏的状态流程：GS_Login-》GS_RoleSelect(角色选择与角色创建)、GS_Rolecreate-》GS_Loadgame-》GS_Game【进入scene】
 */
#include "com/cn/xm/state/GameState.h"

class StateManager {
public:
	StateManager();
	virtual ~StateManager();

public:
	static StateManager* getInstance();
	void setGameState(GameState* state);

private:

private:
	GameState* currState;
	GameState* preState;
};

#endif /* STATEMANAGER_H_ */
