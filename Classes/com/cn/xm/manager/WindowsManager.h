/*
 * WindowsManager.h
 *
 *  Created on: 2016年5月4日
 *      Author: yss
 */

#ifndef WINDOWSMANAGER_H_
#define WINDOWSMANAGER_H_

class WindowsManager {
public:
	WindowsManager();
	virtual ~WindowsManager();

public:
	static WindowsManager* getInstance();

};

#endif /* WINDOWSMANAGER_H_ */
