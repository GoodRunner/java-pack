package com.mybatis.controller;

import com.mybatis.bean.Label;
import com.mybatis.dao.db1.LabelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("data")
public class LabelController {


  @Autowired
  private LabelDao labelDao;

  @RequestMapping("/insert")
  public String insertLabel(){

    //数组需要手动更换
    //String tag[] = {"本季新题" ,"旧题保留"};
    //String tag[] = {"个人信息类" , "个人喜好类" , "技能类" , "休闲活动类" , "抽象类"};
    //String tag[] = {"人物" , "物品" , "事件" , "地点"};
    //String tag[] = {"教育" , "就业" , "科技" , "城建" , "环保" , "健康" , "媒体" , "犯罪" , "慈善" , "人际" , "交通" , "文化"};
    //String tag[] = {"听力顺序练习" ,"按Section练习","按话题分类练习" ,"按题型练习","精听拓展练习"};
    //String tag[] = {"剑雅14", "剑雅13","剑雅12","剑雅11","剑雅10","剑雅9", "剑雅8","剑雅7","剑雅6","剑雅5","剑雅4","剑雅3","剑雅2","剑雅1"};
    String tag[] = {"Test 1", "Test 2","Test 3","Test 4"};
    //String tag[] = {"填空题" , "单选题" , "多选题" , "简答题" , "句子完成题" , "图表题" , "分类题" , "配对题"};
    //String tag[] = {"阅读顺序练习","按话题分类练习" ,"按题型练习"};
    //String tag[] = {"常识与科普" , "历史与发展" , "生物与环境" , "社会与文化" , "医疗与健康" , "商业与经济" , "工业与建筑" , "语言与教育" , "城市与国家"};
    //String tag[] = {"单选题" , "多选题" , "是非题" , "作者观点正误" , "段落信息匹配" , "段落大意匹配" , "人名/日期匹配" , "句子结尾匹配" , "句子完成题" , "信息题空题" , "图表填空题" , "简答题"};
    //String tag[] = {"口语顺序练习","Part 1 话题练习" ,"Part 2&3 话题练习", "口语机经练习"};
    //String tag[] = {"个人信息类" , "个人喜好类" , "技能类" , "休闲活动类" , "抽象类"};
    //String tag[] = {"人物" , "事件" , "物品" , "地点"};
    //String tag[] = {"写作顺序练习" , "Task 1 练习" , "Task 2 练习" , "写作机经练习"};
    //String tag[] = {"线型图" , "柱状图" , "流程图" , "饼型图" , "表格" , "地图" , "拼图"};
    //String tag[] = {"议论类" , "报告类" , "混合型"};
    //String tag[] = {"环境类" , "政府类" , "教育类" , "媒体类" , "社会生活类" , "犯罪类"};
    //String tag[] = {"2019年2月","2019年1月", "2018年12月", "2018年11月"};
    for (int i = 0; i < tag.length ; i++) {
      Label label = new Label();
      label.setKey_code(1195 + i + ""); //需要手动修改ids
      label.setTag_zh_name(tag[i]);
      label.setFun_code("7");// 1听力,2阅读,3剑雅口语,4机经口语,5剑雅写作,6机经写作, 7剑雅 需要手动修改
      label.setParent_id("234"); // 需要手动修改
      label.setLevel(2);
      label.setSort(1 + i);
      label.setType_code("JYTS"); //需要手动修改
      label.setType_desc("剑雅TEST"); //需要手动修改
      label.setIs_must(1);
      label.setIs_multi(Short.decode("0"));
      label.setCreator_id(1);
      label.setUsed(Short.decode("1"));
      label.setCreate_date(new Date());
      label.setUpdater_id(1);
      label.setUpdate_date(new Date());
      labelDao.insertLabel(label);
    }


    return "string";

  }

}
