# easy-canvas
简易画板工具，可以用于海报制作，图片添加水印等

# 1. 简介
## 1.1 背景
因为公司是做基于物联网设备的SaaS软件，涉及不少敏感证件信息、动态绘制宣传海报、设备二维码以及打印小程序后端服务等不少需要处理图片合成图片的地方。

本身基于Java进行图片合成不是什么高深技术，但是直接使用底层api进行封装也过于繁琐。因为本身系统上已经存在一套类似的组件，但是是属于高度定制化的，一部分专门用于绘制设备二维码，一部分专门用于绘制海报，而且代码还散落在各处，不方便统一维护，以及后续扩展。

因此在各类AI工具的帮助下，按照自己想要的结果，封装了一套简易图片处理工具（命名为easy-canvas，该项目名初衷是简化图片处理，由于本质上是在一个背景板上进行各种绘制，因此称之为画板）。

## 1.2 能做什么
设计思路是首先创建一个“画板”，然后在画板上面可以绘制文本、图片、矩形、圆形、线段等。

各元素定位方式均可以采用**相对定位**和**绝对定位**。

另外在项目中将各种基础元素，比如文本、图片等绘制归之于 basic 包下，完成基础的绘制。我在想，有了基础元素是否可以构建更为高级的元素呢？比如平铺，各基础元素的组合等。

按照这个思路，目前已经完成了高级元素中的平铺元素，可以传入不同的基础元素，已实现平铺效果。

# 2. 示例代码

## 2.1 文本展示

```java
EasyCanvas canvas = new EasyCanvas(500, 500);

canvas.addTextElement("正常文字")
    .setFontSize(25)
    .setFontColor(Color.red)
    // 以坐标点为待绘制元素的左上角顶点
    .setPosition(AbsolutePosition.of(CoordinatePoint.of(30, 0), Positions.TOP_LEFT));

canvas.addTextElement("旋转文字")
    .setFontSize(25)
    .setFontColor(Color.red)
    .setRotate(-30)
    .setPosition(AbsolutePosition.of(CoordinatePoint.of(30, 50), Positions.TOP_LEFT));

canvas.addTextElement("透明度为50%")
    .setFontSize(25)
    .setFontColor(Color.red)
    .setAlpha(0.5f)
    .setPosition(AbsolutePosition.of(CoordinatePoint.of(30, 100), Positions.TOP_LEFT));

canvas.asFile("png", "text_basic.png");
```



## 2.2 图片展示



# 3. 迭代计划

## 3.1 未来规划

文本元素

- 支持下划线
- 支持自动换行
  - 换行文本对齐方式
- 支持渐变色
- 支持行高
- 支持文字间距
- 。。。



图片元素

- 支持设置圆角
- 支持设置模糊
- 。。。



以及支持更多的基础元素

## 3.2 更新记录

### 0.0.3
- 图片
  - 功能优化
- 元素支持
  - 增加线段
  - 组合元素（alpha）
- 增加渐变设置

### 0.0.2
- 元素支持
  - 矩形
  - 圆形
  - 五角星
- 文本
  - 增加自动换行（alpha）
  - 支持行高
- 代码优化
  - 增加抽象类[AbstractDimensionElement.java](src%2Fmain%2Fjava%2Fcom%2Faugrain%2Feasy%2Fcanvas%2Felement%2FAbstractDimensionElement.java)完成具有明确宽高的元素的尺寸计算


# 4. 联系作者

邮箱：jcodeporter@gmail.com

# 5. 项目协议

本项目采用Apache License Version 2.0协议
