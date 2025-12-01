package ex2_04;

public class Fushigiyade extends Monster3 {
	//----------コンストラクタ----------
		Fushigiyade() {
			super.setCharacter("ヒトカケ");
		}
		
		Fushigiyade(String trainer, String name) {
			super(trainer, name);
			super.setCharacter("ヒトカケ");
		}
		
		Fushigiyade(String trainer, String name, int lv) {
			super(trainer, name, lv);
			super.setCharacter("ヒトカケ");
		}
		
		//----------メソッド----------
		public void levelUp(int levelUp) {
			setLv(levelUp*1);
			setHp(levelUp * 31);
			setAtk(levelUp * 6);
			setDef(levelUp * 7);
			setSpd(levelUp * 8);
			setHpMax(getHpMax());
		}

}
