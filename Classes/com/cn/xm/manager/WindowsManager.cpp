/*
 * WindowsManager.cpp
 *
 *  Created on: 2016年5月4日
 *      Author: yss
 */

#include "WindowsManager.h"

static WindowsManager* instance;

WindowsManager::WindowsManager() {
}

WindowsManager::~WindowsManager() {
}

WindowsManager* WindowsManager::getInstance(){
	if(!instance){
		instance=new WindowsManager();
	}
	return instance;
}

