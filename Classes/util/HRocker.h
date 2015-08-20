/*
 * HRocker.h
 *
 *  Created on: 2015��8��19��
 *      Author: yss
 */

#ifndef HROCKER_H_
#define HROCKER_H_

#include "cocos2d.h"

USING_NS_CC;

class HRocker: cocos2d::Layer {
public:
	HRocker();
	virtual ~HRocker();

public:
	static HRocker* create(Vec2 aPoint, float aRadius, Sprite* aJsSprite,
			Sprite* aJsBg, bool _isFollowRole);
	/**
	 * ����ҡ��
	 */
	void Active();
	/**
	 * ���ҡ��
	 */
	void Inactive();

private:
	virtual bool onTouchBegan(Touch *pTouch, Event *pEvent);
	virtual void onTouchMoved(Touch *pTouch, Event *pEvent);
	virtual void onTouchEnded(Touch *pTouch, Event *pEvent);

private:
	/* ��ʼ������
	 *    ��һ������aPoint��ҡ�����ĵ������
	 *    �ڶ�������aRadius: ҡ�˵İ뾶
	 *    ����������aJsSprite :ҡ�˿��Ƶ����Դ
	 *    ���ĸ�����aJsBg: ҡ�˱�������Դ
	 *    ���������isFollowRole���Ƿ���ҡ�˿��Ƶ���Զ�����û�������
	 */
	bool initWithCenter(Vec2 aPoint, float aRadius, Sprite* aJsSprite,
			Sprite* aJsBg, bool _isFollowRole);
	Sprite *jsSprite;
	/**
	 * ҡ������
	 */
	Vec2 centerPoint;
	/**
	 *ҡ�˵�ǰλ��
	 */
	Vec2 currentPoint;
	/**
	 * �Ƿ񼤻�ҡ��
	 */
	bool active;
	/**
	 * ҡ�˰뾶
	 */
	float radius;
	/**
	 * �Ƿ�����û����
	 */
	bool isFollowRole;
	/**
	 * ҡ�˷�λ
	 */
	Vec2 getDirection();
	/**
	 * ҡ������
	 */
	float getVelocity();

	void updatePos(float dt);
};

#endif /* HROCKER_H_ */
