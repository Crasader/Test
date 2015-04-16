/*
 * SimpleShooter.cpp
 *
 *  Created on: 2015年4月3日
 *      Author: yss
 */

#include "SimpleShooter.h"

SimpleShooter::SimpleShooter() {
	m_speed = 15;
	m_projectileSpeed = 20;
//	m_projectileList = new Vector<Projectile*>;
}

SimpleShooter::~SimpleShooter() {
}

Scene* SimpleShooter::createScene() {
	Scene * scene = Scene::create();
	SimpleShooter* layer = SimpleShooter::create();
	scene->addChild(layer);
	return scene;
}

bool SimpleShooter::init() {
	if (!Layer::init()) {
		return false;
	}

	visibleSize = CCDirector::getInstance()->getVisibleSize();

	m_foreground = Sprite::create("shooter/Foreground.png");
	m_foreground->setAnchorPoint(Vec2(0, 0.5f));
	m_foreground->setPosition(Vec2(0, visibleSize.height / 2));
	addChild(m_foreground);

	m_background = Sprite::create("shooter/Background.png");
	m_background->setAnchorPoint(Vec2(0, 0.5f));
	m_background->setPosition(Vec2(0, visibleSize.height / 2));
	addChild(m_background);

	m_player = Sprite::create("shooter/Player.png");
	m_player->setAnchorPoint(Vec2(0, 0.5f));
	m_player->setPosition(Vec2(0, visibleSize.height / 2));
	addChild(m_player, 1, "player");

	scheduleUpdate();

	auto listener = EventListenerTouchOneByOne::create();

	listener->onTouchBegan = [&](Touch* touch,Event* event) {
		Vec2 location=this->convertToNodeSpace(touch->getLocation());
		this->m_player->setPosition(location);
		createProjectile(location);
		return true;	
	};

	listener->onTouchEnded = [&](Touch* touch,Event* event) {
		//return true;
	};

	listener->onTouchMoved = [&](Touch* touch,Event* event) {
		//return true;
	};
	_eventDispatcher->addEventListenerWithSceneGraphPriority(listener, this);
	return true;
}

void SimpleShooter::update(float dt) {	
	movePlayer();
	moveProjectiles();
	moveForeground();
	moveBackgroud();
}

void SimpleShooter::movePlayer() {

}

void SimpleShooter::moveProjectiles() {
	Projectile* projectile = nullptr;
	for (int i = 0; i < m_projectileList.size(); ++i) {
		projectile = m_projectileList.at(i);
		projectile->setPositionX(
				projectile->getPositionX() + projectile->getSpeed());

		if (projectile->getPositionX() - projectile->getContentSize().width
				> visibleSize.width) {
			removeProjectile(projectile);
		}
	}
}

void SimpleShooter::moveForeground() {
	float tmpX = m_foreground->getPositionX() - m_speed;

	m_foreground->setPositionX(tmpX);

	float right = m_foreground->getPositionX()
			+ m_foreground->getContentSize().width;

	if (right <= visibleSize.width) {
		m_foreground->setPositionX(right - visibleSize.width);
	}
}

void SimpleShooter::moveBackgroud() {
	float tmpX = m_background->getPositionX() - m_speed / 3;

	m_background->setPositionX(tmpX);

	float right = m_background->getPositionX()
			+ m_background->getContentSize().width;

	if (right <= visibleSize.width) {
		m_background->setPositionX(right - visibleSize.width);
	}
}

void SimpleShooter::createProjectile(Vec2 position) {
	Projectile* projectile = Projectile::create("shooter/Projectile.png");
	projectile->setSpeed(m_projectileSpeed);
	projectile->setPosition(position);
	m_projectileList.pushBack(projectile);
	addChild(projectile,
			((Sprite*) getChildByName("player"))->getLocalZOrder() - 1);
}

void SimpleShooter::removeProjectile(Projectile* projectile) {
	m_projectileList.eraseObject(projectile);
	//m_projectileList.erase(m_projectileList.find(projectile));
	//为什么removechild会报错
	//removeChild(projectile,false);
	log("remove projectile,size:%d", m_projectileList.size());
}
