package ex2_04;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monster2 {
	//---------フィールド-----------
	String character;
	String trainer;
	String name;
	int lv;
	int hp;
	int atk;
	int def;
	int spd;
	int hpMax;
	String wazaNm;
	String wazaDmgRate;
	
	//---------コンストラクタ-------
	Monster2() {
		character = "(unknown)";
		trainer = "(wild)";
		name = "(noname)";
		lv = 1;
		hp = 80;
		atk = 15;
		def = 10;
		spd = 10;
		hpMax = 80;
		wazaNm = "たいあたり";
		wazaDmgRate = "1.0";
	}
	
	Monster2(String character, String name) {
		this();
		this.character = character;
		this.name = name;
	}
	
	Monster2(String trainer, String name, int lv) {
		this(trainer, name);
		this.lv = lv;
		if (lv <= 1) {
			this.lv = 1;
		} else {
			this.lv = lv;
			levelUp(lv);
		}
	}
	

	//---------メソッド-------------
	public String toString() {
		return "<フィールド確認>character:" + this.character + "/trainer:" + this.trainer + "/name:" + this.name + "/lv:"
				+ this.lv + "/hp:" + this.hp + "/atk:" + this.atk + "/def:" + this.def + "/spd:" + this.spd + "/hpMax:"
				+ this.hpMax + "/wazaNm:" + this.wazaNm + "/wazaDmgRate:" + this.wazaDmgRate;
	}

	void levelUp(int levelUp) {
		this.lv = levelUp * 1;
		this.hpMax = levelUp * 30;
		this.atk = levelUp * 5;
		this.def = levelUp * 5;
		this.spd = levelUp * 5;
		this.hp = hpMax;
	}

	void setWaza(String wazaNm, String wazaDmgRate) {
		if (wazaDmgRate.matches("^[0-9]+¥.[0-9]$")) {
			this.wazaNm = wazaNm;
			this.wazaDmgRate = wazaDmgRate;
		} else {
			System.out.println("[ERROR]わざの設定に失敗しました");
		}
	}

	String getStatus() {
		return "[" + this.name + "lv" + this.lv + " " + "HP" + this.hp + "/" + this.hpMax + "]";
	}

	int useWaza() {
		BigDecimal atk = new BigDecimal(this.atk);
		BigDecimal wazaDmgRate = new BigDecimal(this.wazaDmgRate);

		BigDecimal dmg = atk.multiply(wazaDmgRate);

		int dmgResult = dmg.intValue();

		return dmgResult;
	}

	int damaged(int hitDmg) {
		BigDecimal def = new BigDecimal(this.def);
		BigDecimal num1 = new BigDecimal("1");
		BigDecimal num2 = new BigDecimal("120");
		BigDecimal answer1 = def.divide(num2);
		BigDecimal answer2 = answer1.add(num1);
		BigDecimal dmgSubtractRate = num1.divide(answer2, 2, RoundingMode.DOWN);

		BigDecimal hitDmgs = new BigDecimal(hitDmg);
		BigDecimal dmgResult = hitDmgs.multiply(dmgSubtractRate);

		int hitDmgResult = dmgResult.intValue();

		if (this.hp > hitDmgResult) {
			this.hp -= hitDmgResult;
		} else {
			this.hp = 0;
		}

		return hitDmgResult;
	}

}
