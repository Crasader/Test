/*
 * GSFirst.cpp
 *
 *  Created on: 2014骞�11鏈�9鏃�
 *      Author: Administrator
 */

#include "GSFirst.h"

//namespace gameState {

//娓告垙鐘舵�侊細鍚姩鍚庣殑绗竴涓姸鎬�: copy 鍘嬬缉璧勬簮鍖咃紝copy 澹伴煶鏂囦欢. sd鍗′笂瀛樺湪ver.properties锛屾爣蹇楃潃娓告垙鐨勮祫婧愭暟鎹凡缁忓噯澶囧畬姣�
//濡傛灉apk鍖呴噷鏈夊寘鍚祫婧愶紝杩欏氨鏄竴涓В鍘嬬缉鍖呯殑杩囩▼銆傝鐘舵�佸垏鎹㈢殑鏍囧織鏄� ver.properties鐨勫瓨鍦�

GS_First::GS_First() {
	auto scene=FirstScene::create();
	Director::getInstance()->runWithScene(scene);
}

GS_First::~GS_First() {
}

void GS_First::init() {
//	if (!Scene::init()) {
//		return false;
//	}
//
//	auto label = LabelTTF::create("Hello World", "Arial", 24);
//
//	// position the label on the center of the screen
//	label->setPosition(
//			Vec2(origin.x + visibleSize.width / 2,
//					origin.y + visibleSize.height
//							- label->getContentSize().height));
//
//	// add the label as a child to this layer
//	this->addChild(label, 1);
//
//	CCLog("init first");
//}

} /* namespace gameState */
