package com.mybatis.controller;

import com.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-12-11 15:39
 */
@RestController
@RequestMapping("/upload")
public class UploadFileController {

  @Autowired
  private UserService userService;

  /**
   * 通过表格批量上传用户，并入库
   * @param file 上传的文件
   */
  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public void uploadFileUser(MultipartFile file) {
    userService.uploadUser(file);
  }

}