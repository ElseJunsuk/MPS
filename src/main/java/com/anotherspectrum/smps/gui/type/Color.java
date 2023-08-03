package com.anotherspectrum.smps.gui.type;

import com.anotherspectrum.anotherlibrary.menu.ItemCreator;
import com.anotherspectrum.anotherlibrary.utils.StringUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Color {

    RED(9, "<red>", ItemCreator.create(Material.RED_DYE, 1, StringUtil.format("<red>[ 빨강 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <red>빨간색<gray>으로 변경합니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다."), true)),
    ORANGE(10, "<#ffbb33>", ItemCreator.create(Material.ORANGE_DYE, 1, StringUtil.format("<#ffbb33>[ 주황 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <#ffbb33>주황색<gray>으로 변경합니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다."), true)),
    YELLOW(11, "<yellow>", ItemCreator.create(Material.YELLOW_DYE, 1, StringUtil.format("<yellow>[ 노랑 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <yellow>노란색<gray>으로 변경합니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다."), true)),
    LIME(12, "<#bfff00>", ItemCreator.create(Material.LIME_DYE, 1, StringUtil.format("<#bfff00>[ 라임 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <#bfff00>라임색<gray>으로 변경합니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다.", "<gray>- 가격: <white>5,000원"), true)),
    GREEN(13, "<green>", ItemCreator.create(Material.GREEN_DYE, 1, StringUtil.format("<green>[ 초록 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <green>초록색<gray>으로 변경합니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다.", "<gray>- 가격: <white>5,000원"), true)),
    CYAN(14, "<#00ffff>", ItemCreator.create(Material.CYAN_DYE, 1, StringUtil.format("<#00FFFF>[ 청록 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <#00FFFF>청록색<gray>으로 변경합니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다.", "<gray>- 가격: <white>5,000원"), true)),
    LIGHT_BLUE(15, "<#dbe9f4>", ItemCreator.create(Material.LIGHT_BLUE_DYE, 1, StringUtil.format("<#dbe9f4>[ 하늘 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <#dbe9f4>하늘색<gray>으로 변경합니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다.", "<gray>- 가격: <white>5,000원"), true)),
    BLUE(16, "<blue>", ItemCreator.create(Material.BLUE_DYE, 1, StringUtil.format("<blue>[ 파랑 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <blue>파란색<gray>으로 변경합니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다.", "<gray>- 가격: <white>5,000원"), true)),
    PURPLE(17, "<#cc8899>", ItemCreator.create(Material.PURPLE_DYE, 1, StringUtil.format("<#cc8899>[ 보라 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <#cc8899>보라색<gray>으로 변경합니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다.", "<gray>- 가격: <white>5,000원"), true)),
    MAGENTA(18, "<#ff00ff>", ItemCreator.create(Material.MAGENTA_DYE, 1, StringUtil.format("<#ff00ff>[ 마젠타 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <#ff00ff>마젠타색<gray>으로 변경합니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다.", "<gray>- 가격: <white>5,000원"), true)),
    PINK(19, "<#ffc0cb>", ItemCreator.create(Material.PINK_DYE, 1, StringUtil.format("<#FFC0CB>[ 분홍 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <#FFC0CB>분홍색<gray>으로 변경합니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다.", "<gray>- 가격: <white>5,000원"), true)),
    DARK_RED(20, "<dark_red>", ItemCreator.create(Material.REDSTONE, 1, StringUtil.format("<dark_red>[ 진한 빨강 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <dark_red>진한 빨간색<gray>으로 변경합니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다.", "<gray>- 가격: <white>6,000원"), true)),
    WHITE(24, "<white><b>", ItemCreator.create(Material.WHITE_DYE, 1, StringUtil.format("<white>[ 백 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <white>백색<gray>으로 변경합니다.", "<gray>- 기본적으로 <white><b>굵음 효과</b><gray>가 적용됩니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다.", "<gray>- 가격: <white>6,000원"), true)),
    LIGHT_GRAY(25, "<#d3d3d3><b>", ItemCreator.create(Material.LIGHT_GRAY_DYE, 1, StringUtil.format("<#d3d3d3>[ 연한 회색 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <#d3d3d3>연한 회색<gray>으로 변경합니다.", "<gray>- 기본적으로 <#d3d3d3><b>굵음 효과</b><gray>가 적용됩니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다.", "<gray>- 가격: <white>6,000원"), true)),
    BLACK(26, "<#3d3d3d><b>", ItemCreator.create(Material.BLACK_DYE, 1, StringUtil.format("<#3d3d3d>[ 어두운 회색 ]"), StringUtil.ellipsis("<gray>- 클릭 시 <#3d3d3d>어두운 회색<gray>으로 변경합니다.", "<gray>- 기본적으로 <#3d3d3d><b>굵음 효과</b><gray>가 적용됩니다.", "", "<gray>- 클릭 시 미리보기가 가능합니다.", "<gray>- 가격: <white>6,000원"), true));

    private int index;
    private String color;
    private ItemStack item;

    Color(int index, String color, ItemStack item) {
        this.index = index;
        this.color = color;
        this.item = item;
    }

    public int getIndex() {
        return index;
    }

    public String getColor() {
        return color;
    }

    public ItemStack getItem() {
        return item;
    }
}
