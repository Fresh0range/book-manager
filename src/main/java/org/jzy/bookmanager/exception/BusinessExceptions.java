package org.jzy.bookmanager.exception;

public interface BusinessExceptions {
    /** 注册的用户名已存在 */
    BusinessException USERNAME_ALREADY_EXIST = new BusinessException(1001, "用户名已存在");
    /** 注册的两次密码不一致 */
    BusinessException PASSWORD_NOT_SAME = new BusinessException(1002, "两次密码不一致");
    /** 登录时用户名和密码不正确 */
    BusinessException USERNAME_OR_PASSWORD_ERROR = new BusinessException(1003, "用户名/密码错误");
    /** 当前访问的资源需要登录 */
    BusinessException LOGIN_REQUIRED = new BusinessException(1004, "需要登录");
    /** 用户借书的数量大于书籍的库存 */
    BusinessException BOOK_NUM_NOT_ENOUGH = new BusinessException(2001, "书籍库存不足");
    /** 用户借的书不存在或者被移除 */
    BusinessException BOOK_NOT_EXIST = new BusinessException(2002, "书籍不存在或已被移除");
    /** 用户还书的数量大于借的数量 */
    BusinessException BOOK_CHANGE_NUM_ERROR = new BusinessException(2003, "书籍借还数量不正确");
}
