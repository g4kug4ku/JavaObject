package sample2_05;
import sample2_05_1.Sample2_05_2_Car;

class Sample2_05_2_FireTruck extends Sample2_05_2_Car {
	
	//---フィールド------------------------------------------------------
	//※なし
	
	//---コンストラクタ--------------------------------------------------
	//※なし
	//デフォルトコンストラクタ
	Sample2_05_2_FireTruck(){ super(); }
	
	//---メソッド--------------------------------------------------------
	
	//paintメソッド（色を塗る）※セットできる塗装色は「RED」のみ
	//Carクラスの（スーパークラス）のpaintメソッドをオーバーライド
	//Carクラスの（スーパークラス）のフィールドでprotected String color ;となっているからgetterやsetterを使わないでいい
	//protectedという修飾子がついていればサブクラスならgetterやsetterを使わないでいい
	public void paint( String cl ){
		if( cl.equals( "RED" ) ){
			super.color = cl ;
		}
	}
	
	//acceleratorメソッド（現在の速度を1km/h上げる）※80km/h以上にはならないよう制御
	//Carクラス（スーパークラス）のacceleratorメソッドをオーバーライド
	//paintメソッドと違い、Carクラス（スーパークラス）のフィールドでprivate int speed ;となっており、getterやsetterを使わないといけない
	public void accelerator(){
		//getSpeedでスーパークラスのspeedの値を持ってきて比較
		if( super.getSpeed() < 80 ){
			//その値が80より小さければその値に+1してsetSpeedでスーパークラスのフィールドspeedに+1した値を渡す
			super.setSpeed( super.getSpeed() + 1 ) ;
		}
	}
	
}
