#include "HelloWorldScene.h"
#include "util/HRocker.h"

USING_NS_CC;
//using namespace network;

Scene* HelloWorld::createScene() {
	// 'scene' is an autorelease object
	auto scene = Scene::create();
	// 'layer' is an autorelease object
	auto layer = HelloWorld::create();
	// add layer as a child to scene
	scene->addChild(layer);
	// return the scene
	return scene;
}

// on "init" you need to initialize your instance
bool HelloWorld::init() {
	//////////////////////////////
	// 1. super init first
	if (!Layer::init()) {
		return false;
	}
	Size visibleSize = Director::getInstance()->getVisibleSize();
	Vec2 origin = Director::getInstance()->getVisibleOrigin();
//	/////////////////////////////
//	// 2. add a menu item with "X" image, which is clicked to quit the program
//	//    you may modify it.
//	// add a "close" icon to exit the progress. it's an autorelease object
//	auto closeItem = MenuItemImage::create("CloseNormal.png",
//			"CloseSelected.png",
//			CC_CALLBACK_1(HelloWorld::menuCloseCallback, this));
//	closeItem->setPosition(
//			Vec2(
//					origin.x + visibleSize.width
//							- closeItem->getContentSize().width / 2,
//					origin.y + closeItem->getContentSize().height / 2));
//	// create menu, it's an autorelease object
//	auto menu = Menu::create(closeItem, NULL);
//	menu->setPosition(Vec2::ZERO);
//	this->addChild(menu, 1);
//
//	/////////////////////////////
//	// 3. add your codes below...
//	// add a label shows "Hello World"
//	// create and initialize a label
//	auto label = Label::createWithTTF("Hello World", "fonts/Marker Felt.ttf",
//			24);
//	// position the label on the center of the screen
//	label->setPosition(
//			Vec2(origin.x + visibleSize.width / 2,
//					origin.y + visibleSize.height
//							- label->getContentSize().height));
//	// add the label as a child to this layer
//	this->addChild(label, 1);
//	// add "HelloWorld" splash screen"
//	auto sprite = Sprite::create("HelloWorld.png");
//	// position the sprite on the center of the screen
//	sprite->setPosition(
//			Vec2(visibleSize.width / 2 + origin.x,
//					visibleSize.height / 2 + origin.y));
//	// add the sprite as a child to this layer
//	this->addChild(sprite, 0);

	// ²»¸úËæ´¥µã
	Sprite *spRocker = Sprite::create("JoyStickPoint.png"); //Ò¡¸Ë
	Sprite *spRockerBG = Sprite::create("JoyStickBg.png"); //Ò¡¸Ë±³¾°
	HRocker* rocker = HRocker::create(Vec2(150.0f, 130.0f), 50.0f, spRocker,
			spRockerBG, true); //´´½¨Ò¡¸Ë
	this->addChild((Node*) rocker); //Ò¡¸ËÌí¼Óµ½layerÖÐ
	//
	MenuItemImage *pDownloadItem = MenuItemImage::create(
		"JoyStickPoint.png",
		"JoyStickPoint.png",		
		CC_CALLBACK_1(HelloWorld::menuDownloadCallback,this)
		);

	//CC_BREAK_IF(!pDownloadItem);

	Size pWinSize = Director::getInstance()->getWinSize();

	Menu* pDownloadMenu = Menu::create(pDownloadItem, NULL);
	pDownloadMenu->setPosition(ccp(50, 50));

//	CC_BREAK_IF(!pDownloadMenu);

	this->addChild(pDownloadMenu, 1);

	return true;
}

void HelloWorld::menuDownloadCallback(CCObject* pSender){	
/*	HttpRequest* request = new (std::nothrow) HttpRequest();
	request->setUrl("http://www.oschina.net/action/api/news_list");
	request->setRequestType(HttpRequest::Type::POST);

	std::vector<std::string> headers;
	headers.push_back("Content-Type: application/json; charset=utf-8");
	request->setHeaders(headers);

	const char* postData = "catalog=2&pageIndex=1&pageSize=5";

	request->setRequestData(postData, strlen(postData));

//	request->setResponseCallback(this, CC_CALLBACK_1(HelloWorld::onHttpRequestCompleted,this));
	request->setTag("Post_My_Data");
	HttpClient::getInstance()->send(request);
	request->release();*/
}

void HelloWorld::onHttpRequestCompleted(){

}

void HelloWorld::menuCloseCallback(Ref* pSender) {
	Director::getInstance()->end();

#if (CC_TARGET_PLATFORM == CC_PLATFORM_IOS)
	exit(0);
#endif
}
