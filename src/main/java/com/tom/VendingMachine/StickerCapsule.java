package com.tom.VendingMachine;

import java.util.List;

public class StickerCapsule extends ColoredToyCapsule {

	private List<Sticker> stickers;
	
	public void setStickers(List<Sticker> stickers) {
		this.stickers = stickers;
	}
	
	public List<Sticker> getStickers () {
		return this.stickers;
	}
	
	public Describable open() {
		Content content = new Content();
		content.setDescription("few stickers");
		content.addAll(stickers);
		return content;
	}

}
