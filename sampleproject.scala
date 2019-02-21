import org.apache.spark.SparkConf
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.kafka.KafkaUtils
 

object sampleproject
{
 def main(args: Array[String]) {
	val sparkConf = new SparkConf().setAppName("KafkaWordCount")
	val ssc = new StreamingContext(sparkConf, Seconds(120))
 	val data1 = KafkaUtils.createStream(ssc, "localhost:2181", "spark-streaming-consumer-group",Map("logdata" -> 1))
	val lines = data1.map(x=>x._2)
	val d2= lines.filter(x1=>x1.contains("1C69E7AA-C14E-200E-5A77-8EAB2D667A07"))
	val d3 = d2.map(x2=>x2.split(" ")(0))
	d3.print()
	d3.saveAsTextFiles("hdfs://localhost:8020/resultdata1")
	ssc.start()
	ssc.awaitTermination()
	}
   
}


