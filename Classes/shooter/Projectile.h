/*
 * Projectile.h
 *
 *  Created on: 2015Äê4ÔÂ3ÈÕ
 *      Author: yss
 */

#ifndef PROJECTILE_H_
#define PROJECTILE_H_

#include <cocos2d.h>

USING_NS_CC;

class Projectile: public cocos2d::Sprite {
public:
	Projectile();
	virtual ~Projectile();

	CREATE_FUNC(Projectile)
	;

	static Projectile* create(const std::string& filename);

public:
	int getSpeed();
	void setSpeed(int speed);

protected:
	int m_speed;
};

#endif /* PROJECTILE_H_ */
