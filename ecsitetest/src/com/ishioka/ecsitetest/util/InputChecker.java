package com.ishioka.ecsitetest.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class InputChecker {

	public List<String> doCheck(String propertyName, String value, int minLength, int maxLength,
			boolean availableAlphabeticCharacters, boolean availableKanji, boolean availableHiragana, boolean availableHalfWidthDigit,
			boolean availableHalfWidthSymbols, boolean availableKatakana, boolean availableFullWidthSymbols){

				//検証した結果を入れるList
				List<String> stringList = new ArrayList<String>();
				//入力した文字型を入れるList
				List<String> characterTypeList = new ArrayList<String>();

				if(minLength != 0) {
					//入力されているか(空欄かどうか)チェック
					if(StringUtils.isEmpty(value)){
						stringList.add(propertyName + "を入力してください");
					}
				}

				//入力文字数(最小文字数以上、最大文字数以下かどうか)をチェック
				if(value.length() < minLength || value.length() > maxLength){
					stringList.add(propertyName + "は" + minLength + "文字以上" + maxLength + "文字以下で入力してください");
				}


				//入力された文字のタイプから何を判別するか決める
				String regularExpression = "";
				String errorExpression = "";


				if(availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigit ||
						availableHalfWidthSymbols||availableKatakana||availableFullWidthSymbols){
					regularExpression = "[^";
				}
				if(!(availableAlphabeticCharacters) || !(availableKanji) || !(availableHiragana) || !(availableHalfWidthDigit) ||
						!(availableHalfWidthSymbols)|| !(availableKatakana)|| !(availableFullWidthSymbols)){
					errorExpression = "[^";
				}

				if(availableAlphabeticCharacters){
					regularExpression +="a-zA-Z";
						characterTypeList.add("半角英字");
				}else{
					errorExpression += "a-zA-Z";
				}

				if(availableKanji){
					regularExpression +="一-鉞";
					characterTypeList.add("漢字");
				}else{
					errorExpression +="一-鉞";
				}

				if(availableHiragana){
					regularExpression +="ぁ-ん";
					characterTypeList.add("ひらがな");
				}else{
					errorExpression +="ぁ-ん";
				}

				if(availableHalfWidthDigit){
					regularExpression +="0-9";
					characterTypeList.add("半角数字");
				}else{
					errorExpression+="0-9";
				}

				if(availableHalfWidthSymbols){
					regularExpression +="\\[\\]<>@.,;:!#$%&'*+-/=?^_`{|}~ ";
					characterTypeList.add("半角記号");
				}else{
					errorExpression +="\\[\\]<>@.,;:!#$%&'*+-/=?^_`{|}~ ";
				}

				if(availableKatakana){
					regularExpression +="ァ-ヺ";
					characterTypeList.add("カタカナ");
				}else{
					errorExpression +="ァ-ヺ";
				}

				if(availableFullWidthSymbols){
					regularExpression +="￥ー、＜。＞・「」’＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～　０-９ａ-ｚＡ-Ｚ";
					characterTypeList.add("全角記号");
				}else{
					errorExpression +="￥ー、＜。＞・「」’＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～　０-９ａ-ｚＡ-Ｚ";
				}

				if(!StringUtils.isEmpty(regularExpression)){
					regularExpression +="]+";
				}
				if(!StringUtils.isEmpty(errorExpression)){
					errorExpression +="]+";
				}


				//判別した項目に応じてエラーメッセージを返す
				String characterType = "";
				for(int i = 0;i < characterTypeList.size();i++){
					if(i == 0){
						characterType += characterTypeList.get(i).toString();
					}else{
						characterType += "、" + characterTypeList.get(i).toString();
					}
				}
				if(errorExpression.equals("")){
					if(value.matches(regularExpression)){
						stringList.add(propertyName + "は" + characterType + "で入力してください");
					}
				}else{
					if(value.matches(regularExpression)||(!value.matches(errorExpression)&&!value.equals(""))){
						stringList.add(propertyName + "は" + characterType + "で入力してください");
					}
				}

				return stringList;
			}

	public List<String> doCheckSearch(String propertyName, String value, int minLength, int maxLength,
			boolean availableAlphabeticCharacters, boolean availableKanji, boolean availableHiragana, boolean availableHalfWidthDigit,
			boolean availableHalfWidthSymbols, boolean availableKatakana, boolean availableFullWidthSymbols){

				//検証した結果を入れるList
				List<String> stringList = new ArrayList<String>();
				//入力した文字型を入れるList
				List<String> characterTypeList = new ArrayList<String>();

				if(minLength != 0) {
					//入力されているか(空欄かどうか)チェック
					if(StringUtils.isEmpty(value)){
						stringList.add(propertyName + "を入力してください");
					}
				}

				//入力文字数(最小文字数以上、最大文字数以下かどうか)をチェック
				if(value.length() < minLength || value.length() > maxLength){
					stringList.add(propertyName + "は" + minLength + "文字以上" + maxLength + "文字以下で入力してください");
				}


				//入力された文字のタイプから何を判別するか決める
				String regularExpression = "";
				String errorExpression = "";


				if(availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigit ||
						availableHalfWidthSymbols||availableKatakana||availableFullWidthSymbols){
					regularExpression = "[^";
				}
				if(!(availableAlphabeticCharacters) || !(availableKanji) || !(availableHiragana) || !(availableHalfWidthDigit) ||
						!(availableHalfWidthSymbols)|| !(availableKatakana)|| !(availableFullWidthSymbols)){
					errorExpression = "[^";
				}

				if(availableAlphabeticCharacters){
					regularExpression +="a-zA-Z";
						characterTypeList.add("半角英字");
				}else{
					errorExpression += "a-zA-Z";
				}

				if(availableKanji){
					regularExpression +="一-鉞";
					characterTypeList.add("漢字");
				}else{
					errorExpression +="一-鉞";
				}

				if(availableHiragana){
					regularExpression +="ぁ-ん";
					characterTypeList.add("ひらがな");
				}else{
					errorExpression +="ぁ-ん";
				}

				if(availableHalfWidthDigit){
					regularExpression +="0-9";
					characterTypeList.add("半角数字");
				}else{
					errorExpression+="0-9";
				}

				if(availableHalfWidthSymbols){
					regularExpression +="\\[\\]<>@.,;:!#$%&'*+-/=?^_`{|}~";
					characterTypeList.add("半角記号");
				}else{
					errorExpression +="\\[\\]<>@.,;:!#$%&'*+-/=?^_`{|}~";
				}

				if(availableKatakana){
					regularExpression +="ァ-ヺ";
					characterTypeList.add("カタカナ");
				}else{
					errorExpression +="ァ-ヺ";
				}

				if(availableFullWidthSymbols){
					regularExpression +="￥ー、＜。＞・「」’＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～";
					characterTypeList.add("全角記号");
				}else{
					errorExpression +="￥ー、＜。＞・「」’＠．，；：！＃＄％＆’＊＋―／＝？＾＿｀｛｜｝～";
				}

				if(!StringUtils.isEmpty(regularExpression)){
					regularExpression +="]+";
				}
				if(!StringUtils.isEmpty(errorExpression)){
					errorExpression +="]+";
				}


				//判別した項目に応じてエラーメッセージを返す
				String characterType = "";
				for(int i = 0;i < characterTypeList.size();i++){
					if(i == 0){
						characterType += characterTypeList.get(i).toString();
					}else{
						characterType += "、" + characterTypeList.get(i).toString();
					}
				}
				if(errorExpression.equals("")){
					if(value.matches(regularExpression)){
						stringList.add(propertyName + "は" + characterType + "で入力してください");
					}
				}else{
					if(value.matches(regularExpression)||(!value.matches(errorExpression)&&!value.equals(""))){
						stringList.add(propertyName + "は" + characterType + "で入力してください");
					}
				}

				return stringList;
			}


	//入力パスワードと確認パスワードが一致しているか検証する
	public List<String> doPasswordCheck(String password,String reConfirmationPassword){
		List<String> stringList = new ArrayList<String>();
		if(!(password.equals(reConfirmationPassword))){
			stringList.add("入力されたパスワードが異なります");
		}
		return stringList;
	}

}
