/*
 * FirstScene.cpp
 *
 *  Created on: 2016年5月4日
 *      Author: yss
 */

#include "FirstScene.h"

FirstScene::FirstScene() {

}

FirstScene::~FirstScene() {
}

bool FirstScene::init() {
	if (!Scene::init()) {
		return false;
	}

	return true;
}

