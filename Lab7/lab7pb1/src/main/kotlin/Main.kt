import java.io.File

class SyslogRecords(private val LogLine: String)
{
    private var TimeStamp: String = "";
    private var HostName: String = "";
    private var Application_name: String = "";
    private var PID: String = "";
    private var LogEntry: String = "";

    init {
        println("another one:")

        this.TimeStamp = LogLine.slice(IntRange(0, 14))
        println("TimeStamp: " + this.TimeStamp)

        this.HostName = LogLine.slice(IntRange(16, 21))
        println("HostName: " + this.HostName)

        this.Application_name = LogLine.slice(IntRange(23, LogLine.length-1))
        this.Application_name = this.Application_name.substringBefore(delimiter = "[", missingDelimiterValue = this.Application_name.substringBefore(delimiter = ":"))
        println("ApplicationName: " + this.Application_name)

        this.PID = LogLine.substringAfter(delimiter = "[", missingDelimiterValue = null.toString())
        this.PID = this.PID.substringBefore(delimiter = "]", missingDelimiterValue = null.toString())
        println("PID: " + this.PID)

        this.LogEntry = LogLine.slice(IntRange(23, LogLine.length-1))
        this.LogEntry = this.LogEntry.substringAfter(delimiter = ":", missingDelimiterValue = null.toString())
        println("LogEntry: " + this.LogEntry + "\n")
    }
}

fun main(args: Array<String>) {
    val syslog = File("./syslog")
    val log = syslog.readText().splitToSequence("\n").map{SyslogRecords(it)};
    log.toList()


}