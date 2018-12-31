# oauth2 #
## 授权方式 ##
### 授权码模式（authorization code） ###
1. 用户访问客户端，后者将前者导向认证服务器
	- response_type：表示授权类型，必选项，此处的值固定为"code"
	- client_id：表示客户端的ID，必选项
	- redirect_uri：表示重定向URI，可选项
	- scope：表示申请的权限范围，可选项
	- state：表示客户端的当前状态，可以指定任意值，认证服务器会原封不动地返回这个值。
`localhost:8080/oauth/authorize?response_type=code&client_id=${client_id}&state=xyz&redirect_uri=${redirect_uri}`
2. 用户选择是否给予客户端授权
3. 假设用户给予授权，认证服务器将用户导向客户端事先指定的"重定向URI"（redirection URI），同时附上一个授权码
	- code：表示授权码，必选项。该码的有效期应该很短，通常设为10分钟，客户端只能使用该码一次，否则会被授权服务器拒绝。该码与客户端ID和重定向URI，是一一对应关系。
	- state：如果客户端的请求中包含这个参数，认证服务器的回应也必须一模一样包含这个参数。
	`https://client.example.com/cb?code=SplxlOBeZQQYbYS6WxSbIA&state=xyz`
4. 客户端收到授权码，附上早先的"重定向URI"，向认证服务器申请令牌。这一步是在客户端的后台的服务器上完成的，对用户不可见
	- grant_type：表示使用的授权模式，必选项，此处的值固定为"authorization_code"。
	- code：表示上一步获得的授权码，必选项。
	- redirect_uri：表示重定向URI，必选项，且必须与1步骤中的该参数值保持一致。
	- client_id：表示客户端ID，必选项。
	```
	localhost:8080/oauth/token?grant_type=authorization_code&code=${code}&redirect_uri=${redirect_uri}
	Authorization: Basic czZCaGRSa3F0MzpnWDFmQmF0M2JW
	Content-Type: application/x-www-form-urlencoded```
5. 认证服务器核对了授权码和重定向URI，确认无误后，向客户端发送访问令牌（access token）和更新令牌（refresh token）
	- access_token：表示访问令牌，必选项。
	- token_type：表示令牌类型，该值大小写不敏感，必选项，可以是bearer类型或mac类型。
	- expires_in：表示过期时间，单位为秒。如果省略该参数，必须其他方式设置过期时间。
	- refresh_token：表示更新令牌，用来获取下一次的访问令牌，可选项。
	- scope：表示权限范围，如果与客户端申请的范围一致，此项可省略

### 简化模式（implicit） ###

### 密码模式（password） ###
1. 用户向客户端提供用户名和密码
2. 客户端将用户名和密码发给认证服务器，向后者请求令牌
	- grant_type：表示授权类型，此处的值固定为"password"，必选项。
	- username：表示用户名，必选项。
	- password：表示用户的密码，必选项。
	- scope：表示权限范围，可选项。
	`localhost:8080/oauth/token?grant_type=password&username=${username}&password=${password}`

### 客户端模式（credentials） ###

### 更新令牌（refresh_token） ###
- granttype：表示使用的授权模式，此处的值固定为"refreshtoken"，必选项。
- refresh_token：表示早前收到的更新令牌，必选项。
- scope：表示申请的授权范围，不可以超出上一次申请的范围，如果省略该参数，则表示与上一次一致
```
Authorization: Basic czZCaGRSa3F0MzpnWDFmQmF0M2JW
Content-Type: application/x-www-form-urlencoded
localhost:8080/oauth/token?grant_type=refresh_token&refresh_token=tGzv3JOkF0XG5Qx2TlKWIA
``` 

## 使用 ##

> 整合spring-boot-security、spring-security-oauth2、redis

1. 配置 `@EnableAuthorizationServer` 主要配置文件，配置授权的相关信息、配置客户端、配置token存储方式

2. 配置 `@EnableResourceServer` 请求资源的配置

3. 配置 `@EnableWebSecurity` 安全配置 配置那些拦截那些不拦截

> 我用的是redis的token存储方式，在这里主要说一下，用框架的`RedisTokenStore`会报错，所以自己实现`public class MyRedisTokenStore implements TokenStore`里面是`RedisTokenStore`的代码，只是把所有的`conn.set(`换成`conn.stringCommands().set(`,里面的方法也可以根据自己的业务修改，主要是存和取两个方法`getAccessToken`和`storeAccessToken`

> 再说一下，升级到security5之后的密码存储方式，需要有一个passwordEncoder的id,配置一个这个
```
    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
```
支持的加密方式有 
```
bcrypt、ldap、MD4、MD5、noop、pbkdf2、scrypt、SHA-1、SHA-256、sha256

```

用户中密码存储方式要转变成`{加密方式id}加密后的字符串`--`{MD5}iuwheuigb87923rt7y374tf`


