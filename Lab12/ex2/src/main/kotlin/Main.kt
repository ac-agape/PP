import java.text.SimpleDateFormat
import java.util.Date;

fun String.toDate(form : SimpleDateFormat):Date{
    val date = form.parse(this);
    return date;
}

fun main(args: Array<String>) {
    val form = SimpleDateFormat("dd-MM-yyyy");
    val text = "16-05-2023";
    val data = text.toDate(form);
    println("date: " + data);
}