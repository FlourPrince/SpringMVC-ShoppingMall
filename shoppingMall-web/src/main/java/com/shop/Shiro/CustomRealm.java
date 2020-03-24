package com.shop.Shiro;

import org.apache.log4j.chainsaw.Main;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

@Component
public class CustomRealm extends AuthorizingRealm {
	// 设置realm的名称
	@Override
	public void setName(String name) {
		super.setName("customRealm");
	}


	/**
	 * 授权,只有成功通过doGetAuthenticationInfo方法的认证后才会执行。
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {

		/*
		 * // 从 principals获取主身份信息 // 将getPrimaryPrincipal方法返回值转为真实身份类型（
		 * //在上边的doGetAuthenticationInfo认证通过填充到SimpleAuthenticationInfo中身份类型），
		 * TAdminUser activeUser = (TAdminUser)
		 * principals.getPrimaryPrincipal(); // 根据身份信息获取权限信息 // 从数据库获取到权限数据
		 * TAdminRole adminRoles = adminUserService.getAdminRoles(activeUser);
		 * // 单独定一个集合对象 List<String> permissions = new ArrayList<String>(); if
		 * (adminRoles != null) { permissions.add(adminRoles.getRoleKey()); } //
		 * // 查到权限数据，返回授权信息(要包括 上边的permissions) SimpleAuthorizationInfo
		 * simpleAuthorizationInfo = new SimpleAuthorizationInfo(); // //
		 * 将上边查询到授权信息填充到simpleAuthorizationInfo对象中
		 * simpleAuthorizationInfo.addStringPermissions(permissions); return
		 * simpleAuthorizationInfo;
		 */

		return null;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		System.out.println("进来验证了");
		 //获取输入的账号
        String username = (String) token.getPrincipal();
       //如果不是zhangshan，就认为账号不正确，返回null
       if(!(username).equals("zhangshan")){
    	   throw new UnknownAccountException("账号不存在");
       }
       //交由shiro判断，账号：zhangshan,密码：123456,是否与用户输入的匹配
       Object principal=username;
       Object credentials="e10adc3949ba59abbe56e057f20f883e";
       ByteSource credentialsSalt =ByteSource.Util.bytes(username);
        return new SimpleAuthenticationInfo(principal,credentials,getName());

		/*
		 * 
		 * // token中包含用户输入的用户名和密码 // 第一步从token中取出用户名 String userName = (String)
		 * token.getPrincipal(); // 第二步：根据用户输入的userCode从数据库查询 TAdminUser
		 * adminUser = adminUserService.getAdminUserByUserName(userName); //
		 * 如果查询不到返回null if (adminUser == null) {// return null; } // 获取数据库中的密码
		 * String password = adminUser.getPassword();
		 *//**
			 * 认证的用户,正确的密码
			 */
		/*
		 * AuthenticationInfo authcInfo = new
		 * SimpleAuthenticationInfo(adminUser, password, this.getName()); //MD5
		 * 加密+加盐+多次加密
		 * 
		 * return authcInfo;
		 */}

	// 清除缓存
/*
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
*/

   public static void main(String[] args) {
	   String algorithmName="MD5";
	   Object source="123456";
	   Object salt="";
	   int hashIterations=1;
	    Object object=  new SimpleHash(algorithmName, source, salt, hashIterations);
	    System.out.println(object);
   }
}
