/*
 * GSFirst.h
 *
 *  Created on: 2014年11月9日
 *      Author: Administrator
 */

#ifndef GSFIRST_H_
#define GSFIRST_H_

#include "GameState.h"
#include "cocos2d.h"
#include "com/cn/xm/first/FirstScene.h"
USING_NS_CC;

class GS_First: public GameState {
public:
	GS_First();
	virtual ~GS_First();

public:
	virtual void init();
};

#endif /* GSFIRST_H_ */
