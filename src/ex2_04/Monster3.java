package ex2_04;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monster3 {
	//---------フィールド-----------
		private String character;
		private String trainer;
		private String name;
		private int lv;
		private int hp;
		private int atk;
		private int def;
		private int spd;
		private int hpMax;
		private String wazaNm;
		private String wazaDmgRate;
		
		//---------コンストラクタ-------
		Monster3() {
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
		
		Monster3(String character, String name) {
			this();
			this.character = character;
			this.name = name;
		}
		
		Monster3(String trainer, String name, int lv) {
			this("(unknown)", name);
			this.trainer = trainer;
			this.name = name;
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

		public void levelUp(int levelUp) {
			this.lv = levelUp * 1;
			this.hpMax = levelUp * 30;
			this.atk = levelUp * 5;
			this.def = levelUp * 5;
			this.spd = levelUp * 5;
			this.hp = hpMax;
		}

		public void setWaza(String wazaNm, String wazaDmgRate) {
			if (wazaDmgRate.matches("^[0-9]+¥.[0-9]$")) {
				this.wazaNm = wazaNm;
				this.wazaDmgRate = wazaDmgRate;
			} else {
				System.out.println("[ERROR]わざの設定に失敗しました");
			}
		}

		public String getStatus() {
			return "[" + this.name + "lv" + this.lv + " " + "HP" + this.hp + "/" + this.hpMax + "]";
		}

		public int useWaza() {
			BigDecimal atk = new BigDecimal(this.atk);
			BigDecimal wazaDmgRate = new BigDecimal(this.wazaDmgRate);

			BigDecimal dmg = atk.multiply(wazaDmgRate);

			int dmgResult = dmg.intValue();

			return dmgResult;
		}

		public int damaged(int hitDmg) {
			BigDecimal def = new BigDecimal(this.def);
			BigDecimal num1 = new BigDecimal("1");
			BigDecimal num2 = new BigDecimal("120");
			BigDecimal answer1 = def.divide(num2, 2, RoundingMode.DOWN);
			BigDecimal answer2 = num1.add(answer1);
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
		
		
		//---------setter/getter--------------------
		public String getCharacter() {
			return character;
		}
		
		public void setCharacter(String character) {
			this.character = character;
		}
		
		public String getTrainer() {
			return trainer;
		}
		
		public void setTrainer(String trainer) {
			this.trainer = trainer;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getLv() {
			return lv;
		}
		
		public void setLv(int lv) {
			this.lv = lv;
		}
		
		public int getHp() {
			return hp;
		}
		
		public void setHp(int hp) {
			this.hp = hp;
		}
		
		public int getAtk() {
			return atk;
		}
		
		public void setAtk(int atk) {
			this.atk = atk;
		}
		
		public int getDef() {
			return def;
		}
		
		public void setDef(int def) {
			this.def = def;
		}
		
		public int getSpd() {
			return spd;
		}
		
		public void setSpd(int spd) {
			this.spd = spd;
		}
		
		public int getHpMax() {
			return hpMax;
		}
		
		public void setHpMax(int hpMax) {
			this.hpMax = hpMax;
		}
		
		public String getWazaNm() {
			return wazaNm;
		}
		
		public void setWazaNm(String wazaNm) {
			this.wazaNm = wazaNm;
		}
		
		public String getWazaDmgRate() {
			return wazaDmgRate;
		}
		
		public void setWazaDmgRate(String wazaDmgRate) {
			this.wazaDmgRate = wazaDmgRate;
		}
		
		

}
