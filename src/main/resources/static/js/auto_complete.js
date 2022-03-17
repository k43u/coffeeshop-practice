'use strict';
$(function() {
	var itemList = [
		"Gorgeous4サンド",
		"エスプレッソフラペチーノ",
		"Specialキャラメルドーナッツ",
		"チョコクッキー",
		"カフェモカ",
		"カフェラテ",
		"カプチーノ",
		"キャラメルマキアート",
		"キャラメルフラペチーノ",
		"バニラ クリーム フラペチーノ",
		"ダークモカフラペチーノ",
		"抹茶クリームフラペチーノ",
		"ドリップコーヒー",
		"アイスコーヒー",
		"アメリカン",
		"エスプレッソ",
		"ナッティホワイトモカ",
		"ジンジャーブレッドラテ"
	];


	$('#autocomplete_search').autocomplete({
		source: itemList,
		autoFocus: true,
		delay: 100
	});
});