package main.java.kr.co.weather.common.Enum;

public enum Clothes {
	
	UNDER4("패딩, 두꺼운 코트, 누빔 옷, 기모, 목도리"),
	MORETHAN4UNDER9("울 코트, 히트택, 가죽 옷, 기모"),
	MORETHAN9UNDER12("트렌치 코트, 야상, 점퍼, 스타킹, 기모바지"),
	MORETHAN12UNDER17("자켓, 가디건, 청자켓, 니트, 스타킹, 청바지"),
	MORETHAN17UNDER20("얇은 가디건, 니트, 맨투맨, 후드, 긴 바지"),
	MORETHAN20UNDER23("블라우스, 긴팔 티, 면바지, 슬랙스"),
	MORETHAN23UNDER28("반팔, 얇은 셔츠, 반바지, 면바지"),
	OVER28("민소매, 반팔, 반바지, 짧은 치마, 린넨 옷");
	
	private String clothes;

	Clothes(String clothes){
		this.clothes = clothes;
	}
	
	public String getClothes() {
		return this.clothes;
	}
	
	public static String getTemperature(double temp) {
		String clothesRecommend = "";
		if(temp < 4) {
			clothesRecommend = UNDER4.getClothes();
		}else if(temp >= 4 && temp < 9) {
			clothesRecommend = MORETHAN4UNDER9.getClothes();
		}else if(temp >= 9 && temp < 12) {
			clothesRecommend = MORETHAN9UNDER12.getClothes();
		}else if(temp >= 12 && temp < 17) {
			clothesRecommend = MORETHAN12UNDER17.getClothes();
		}else if(temp >= 17 && temp < 20) {
			clothesRecommend = MORETHAN17UNDER20.getClothes();
		}else if(temp >= 20 && temp < 23) {
			clothesRecommend = MORETHAN20UNDER23.getClothes();
		}else if(temp >= 23 && temp < 28) {
			clothesRecommend = MORETHAN23UNDER28.getClothes();
		}else if(temp >= 28) {
			clothesRecommend = OVER28.getClothes();
		}
		return clothesRecommend;
	}
}
