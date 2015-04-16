/*
 * Projectile.cpp
 *
 *  Created on: 2015Äê4ÔÂ3ÈÕ
 *      Author: yss
 */

#include "Projectile.h"

Projectile::Projectile() {
	m_speed = 0;
}

Projectile::~Projectile() {
}

Projectile* Projectile::create(const std::string& filename) {
	return (Projectile*) Sprite::create(filename);
}

int Projectile::getSpeed() {
	return m_speed;
}

void Projectile::setSpeed(int speed) {
	m_speed = speed;
}

