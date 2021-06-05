/**
 * date:2019/08/16
 * author:Mr.Chung
 * description:姝ゅ鏀緇ayui鑷畾涔夋墿灞�
 * version:2.0.4
 */

window.rootPath = (function (src) {
    src = document.scripts[document.scripts.length - 1].src;
    return src.substring(0, src.lastIndexOf("/") + 1);
})();

layui.config({
    base: rootPath + "lay-module/",
    version: true
}).extend({
    miniAdmin: "layuimini/miniAdmin", // layuimini鍚庡彴鎵╁睍
    miniMenu: "layuimini/miniMenu", // layuimini鑿滃崟鎵╁睍
    miniTab: "layuimini/miniTab", // layuimini tab鎵╁睍
    miniTheme: "layuimini/miniTheme", // layuimini 涓婚鎵╁睍
    miniTongji: "layuimini/miniTongji", // layuimini 缁熻鎵╁睍
    step: 'step-lay/step', // 鍒嗘琛ㄥ崟鎵╁睍
    treetable: 'treetable-lay/treetable', //table鏍戝舰鎵╁睍
    tableSelect: 'tableSelect/tableSelect', // table閫夋嫨鎵╁睍
    iconPickerFa: 'iconPicker/iconPickerFa', // fa鍥炬爣閫夋嫨鎵╁睍
    echarts: 'echarts/echarts', // echarts鍥捐〃鎵╁睍
    echartsTheme: 'echarts/echartsTheme', // echarts鍥捐〃涓婚鎵╁睍
    wangEditor: 'wangEditor/wangEditor', // wangEditor瀵屾枃鏈墿灞�
    layarea: 'layarea/layarea', //  鐪佸競鍘垮尯涓夌骇鑱斿姩涓嬫媺閫夋嫨鍣�
});