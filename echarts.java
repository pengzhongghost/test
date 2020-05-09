1.前台代码：
<script type="text/javascript">
            $(function () {
                $.post("/EchartsController/showEcharts",{},function (data) {
                    var names=[];
                    var list1 = data["incomes"];
                    for (var i=0;i<list1.length;i++){
                        names.push(list1[i].name);
                    }
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('container'));
                    // 指定图表的配置项和数据
                    var option = {
                        title: {
                            text: '某站点用户访问来源',
                            subtext: '纯属虚构',
                            left: 'center'
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left',
                            data: names,
                        },
                        series: [
                            {
                                name: '访问来源',
                                type: 'pie',
                                radius: '55%',
                                center: ['50%', '60%'],
                                data:list1,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                })
            })
    </script>
2.后台代码
  @Controller
  @RequestMapping("/EchartsController")
  public class EchartsController {
      @Autowired
      IncomeService incomeService;
      @RequestMapping("/showEcharts")
      @ResponseBody
      public Object showEcharts(){
          List<IncomeDetails> incomes=incomeService.selectAll();
          HashMap<String,List> hashMap=new HashMap<>();
              hashMap.put("incomes",incomes);
          return hashMap;
      }
  }
  public class IncomeDetails {
      private String name;
      private Double value;
      public IncomeDetails() {
      }
      public IncomeDetails(String name, Double value) {
          this.name = name;
          this.value = value;
      }
      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public Double getValue() {
          return value;
      }

      public void setValue(Double value) {
          this.value = value;
      }
  }
