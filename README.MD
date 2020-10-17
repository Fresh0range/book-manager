图书管理系统
==

## 接口
### 接口一览
```
-管理员
    -登录
    -登出
    -添加书籍
    -删除书籍
-普通用户
    -注册
    -登录
    -登出
    -按书名查找书籍
    -查看书籍详情
    -借书
    -还书
    -查看自己借的书
```
###管理员接口
* 登录`POST` `localhost:8000/api/admin/user/login`
```
{
    "userName": "admin",
    "password": "admin"
}
```
* 登出`POST` `localhost:8000/api/admin/user/logout`
```
无请求体
```
* 添加书籍`POST` `localhost:8000/api/admin/user/books`
```
{
	"book":{
		"name":"数据结构",
		"author":"严蔚敏",
		"introduce":"数据结构是计算机存储、组织数据的方式。"
},
	"change": 6
}
```
* 删除书籍`POST` `localhost:8000/api/admin/user/books`
```
{
	"book":{
		"name":"数据结构",
		"author":"严蔚敏",
		"introduce":"数据结构是计算机存储、组织数据的方式。"
},
	"change": -6
}
```
###普通用户接口
* 注册`POST` `localhost:8000/api/user/register`
```
{
    "userName": "{userName}",
    "password": "{password}",
    "repeatPassword": "{repeat password}",
    "email": "{email}"
}
```
* 登录`POST` `localhost:8000/api/user/login`
```
{
    "userName": "{userName}",
    "password": "{password}"
}
```
* 登出`POST` `localhost:8000/api/user/logout`
```
无请求体
```
* 按名称查找书籍`GET` `localhost:8000/api/books/searchBy?key=name&value=`
* 查看书籍详情`GET` `localhost:8000/api/books/1`
* 借书`POST` `localhost:8000/api/user/books`
```
{
    "bookId": 1,
    "change": -2
}
```
* 还书`POST` `localhost:8000/api/user/books`
```
{
    "bookId": 1,
    "change": 2
}
```
* 查看自己借的书籍 `GET` `localhost:8000/api/user/books`