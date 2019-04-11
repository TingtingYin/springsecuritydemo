1. security 默认basic 认证（账号：user,密码：控制台输出的密码）
2. security 表单登录（账号：user,密码：控制台输出的密码）
3. MyDetailsService
4. 7个参数的User
5. BCryptPasswordEncoder(每次密码不一样)
6. 404错误处理
7. 自定义登录页面
8.实现自定义登录页面
9. 登录成功处理，访问index.html,输入账号密码后，
出现authentication的json信息
10. 自定义登录失败处理
11. 配置loginType
    - json : 返回json信息
    - redirect : 登录成功后跳转到用户要访问的页面（默认）
12. 获取当前用户信息
13. 图形验证码显示
14. 图形验证码校验逻辑
    - 访问login.html,不输入验证码，发现返回fail的json信息
15. 验证码不通过，filter直接return
16. 重构图形验证码，使其在其他项目中可以重用
    -默认配置：core
    -应用级配置：demo
    -请求级配置：配置值在调用接口时传递