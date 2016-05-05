/*
 * SimpleShooter.h
 *
 *  Created on: 2015Äê4ÔÂ3ÈÕ
 *      Author: yss
 */

#ifndef SIMPLESHOOTER_H_
#define SIMPLESHOOTER_H_

#include <cocos2d.h>

#include "Projectile.h"

USING_NS_CC;

using namespace std;

class SimpleShooter: public cocos2d::Layer {
public:
	SimpleShooter();
	virtual ~SimpleShooter();

	static Scene* createScene();
	virtual bool init();
	virtual void update(float dt);

	CREATE_FUNC(SimpleShooter)
	;
private:
	Sprite* m_foreground;
	Sprite* m_background;
	Sprite* m_player;

	int m_speed;
	int m_projectileSpeed;

	Size visibleSize;
	Vector<Projectile*> m_projectileList;
private:
	void movePlayer();
	void moveProjectiles();
	//void moveForeground();
	//void moveBackgroud();
	void createProjectile(Vec2 position);
	void removeProjectile(Projectile* projectile);
};

#endif /* SIMPLESHOOTER_H_ */
