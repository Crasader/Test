/****************************************************************************
Copyright (c) 2008-2010 Ricardo Quesada
Copyright (c) 2010-2012 cocos2d-x.org
Copyright (c) 2011      Zynga Inc.
Copyright (c) 2013-2014 Chukong Technologies Inc.
 
http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 ****************************************************************************/
package org.cocos2dx.cpp;

import org.cocos2dx.lib.Cocos2dxActivity;

import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import enums.Operators;

public class AppActivity extends Cocos2dxActivity {

	public void getNetWorkClass() {
		// getContext().getSystemService(Context.CONNECTIVITY_SERVICE)
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getOperators(this);
		Toast.makeText(getApplicationContext(),
				String.valueOf("运营商：" + getOperators(this)), Toast.LENGTH_SHORT)
				.show();
	}

	/**
	 * 返回运营商 需要加入权限 <uses-permission
	 * android:name="android.permission.READ_PHONE_STATE"/> <BR>
	 * 
	 * @return 1,代表中国移动，2，代表中国联通，3，代表中国电信，0，代表未知
	 * @author youzc@yiche.com
	 */
	public String getOperators(Context context) {
		// 移动设备网络代码（英语：Mobile Network Code，MNC）是与移动设备国家代码（Mobile Country
		// Code，MCC）（也称为“MCC / MNC”）相结合, 例如46000，前三位是MCC，后两位是MNC 获取手机服务商信息
		String OperatorsName = Operators.NONE;
		String IMSI = ((TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE)).getSubscriberId();
		// IMSI号前面3位460是国家，紧接着后面2位00 运营商代码
		// System.out.println(IMSI);
		if (IMSI != null) {
			if (IMSI.startsWith("46000") || IMSI.startsWith("46002")
					|| IMSI.startsWith("46007")) {
				OperatorsName = Operators.CMCC;
			} else if (IMSI.startsWith("46001") || IMSI.startsWith("46006")) {
				OperatorsName = Operators.CHU;
			} else if (IMSI.startsWith("46003") || IMSI.startsWith("46005")) {
				OperatorsName = Operators.CHA;
			}
		}
		return OperatorsName;
	}
}
