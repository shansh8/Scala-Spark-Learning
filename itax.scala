val data = sc.textFile("itax-company.txt")
val srdd = data.map(line => {val t = line.split("\\s+"); (t(0), t(1).toInt)})
srdd.reduceByKey((a,b) => a+b)
val data1 = sc.textFile("itax-ind.txt")
val data1rdd = data1.map(line => {val t = line.split("\\s+"); (t(0), t(1).toInt)})
f1.join(data1rdd).filter(t => (t._2._1 != t._2._2)).foreach(println)
