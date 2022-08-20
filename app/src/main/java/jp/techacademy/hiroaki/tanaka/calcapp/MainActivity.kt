package jp.techacademy.hiroaki.tanaka.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var num1: Double = 0.0
    var num2: Double = 0.0
    var sum: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plus_button.setOnClickListener(this)
        minus_button.setOnClickListener(this)
        multiply_button.setOnClickListener(this)
        divide_button.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        num1 = (editText1.text.toString().toDoubleOrNull()?:0.0 ) as Double
        num2 = (editText2.text.toString().toDoubleOrNull()?:0.0 ) as Double

        if ((num1 == 0.0) || (num2 == 0.0)) {
            showAlertDialog()
        }
        else if (v != null) {
            if (v.id == R.id.plus_button) {
                sum = num1 + num2
            } else if (v.id == R.id.minus_button) {
                sum = num1 - num2
            } else if (v.id == R.id.multiply_button) {
                sum = num1 * num2
            } else if (v.id == R.id.divide_button) {
                sum = num1 / num2
            }
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("VALUE1", sum)
            startActivity(intent)
        }


    }

    private fun showAlertDialog() {
        // AlertDialog.Builderクラスを使ってAlertDialogの準備をする
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("お願い")
        alertDialogBuilder.setMessage("0を超える数値を入れてください")

        // AlertDialogを作成して表示する
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}