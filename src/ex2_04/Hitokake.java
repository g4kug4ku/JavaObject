package ex2_04;

public class Hitokake extends Monster3 {
	//----------コンストラクタ----------
	Hitokake() {
		super.setCharacter("ヒトカケ");
	}
	
	Hitokake(String trainer, String name) {
		super(trainer, name);
		super.setCharacter("ヒトカケ");
	}
	
	Hitokake(String trainer, String name, int lv) {
		super(trainer, name, lv);
		super.setCharacter("ヒトカケ");
	}
	
	//----------メソッド----------
	public void levelUp(int levelUp) {
		setLv(levelUp*1);
		setHp(levelUp * 29);
		setAtk(levelUp * 8);
		setDef(levelUp * 5);
		setSpd(levelUp * 9);
		setHpMax(getHpMax());
	}

}
