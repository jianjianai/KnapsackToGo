# 跨服背包同步 —— 一款无需数据库的跨服背包同步插件！
最近有个想法，想开一个1.16.1的群组服，于是我就上论坛搜索了下，发现没有几款可以跨服同步背包的插件，少数的几款插件要么用不了，要么就是付费的，于是我就想自己开发一款跨服背包同步插件，我只是开一个生存群组服，服务器cpu核心非常多，单开无法发挥最佳新能，也不需要在多台物理机上同步数据，于是我就开发了一款不用数据库的同步插件，这样我就免得折腾数据库了。

## 为什么选择本插件
1.  **轻量级：**插件非常小功能刚刚好好满足需求，不多也不少。
2. **配置简单：**插件只用设置一个工作路径即可完美运行，不需要下载前置，不需要配置数据库，开 封即用，简单方便。
3. **多线程：**因为是我自己服务器用的，所以考虑了加载时卡顿问题，服务器保存数据都是采用异步操作，只有少数必要的操作放在主线程。
4. **安全可靠：**插件有加锁功能，几乎杜绝了跨服刷物品的问题，除非服务器崩溃。
5. **无需插件桥：**插件只需要安装在子服务器即可，不需要任何的辅助同步功能。
6. **统一配置：**修改全服的配置，只需要一个配置文件。

## 命令和权限
 命令：/保存背包 , bcbb, baocunbeibao 权限：跨服背包.保存背包
命令：/加载背包 , jzbb, jiazaibeibao 权限：跨服背包.加载背包
## 更新计划
- 背包同步：ok
- 装备同步：ok
- 副手同步：ok
- 优化同步体验：ok
- 手动解锁命令：更新中...
- 服务器个性化设置：no
- 血量同步：no
- 饱食度同步：no
- 药水效果同步：no
- 经验同步：no
- 经济同步：no
- 电卷同步：no
