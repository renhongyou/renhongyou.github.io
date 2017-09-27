using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewFeaturesForCSharp3._02_AutoAttribute
{
    class Test
    {
        class Person
        {
            // 标准实现的属性
            int _age;
            public int Age
            {
                get { return _age; }
                set
                {
                    if (value < 0 || value > 130)
                    {
                        Console.WriteLine("设置的年龄有误！");
                        return;
                    }
                    _age = value;
                }
            }
            
            // 自动实现的属性
            public string Name { get; set; }
        }

        static void Main(string[] args)
        {
            Person p = new Person();
            p.Age = 18;
            p.Name = "小王";
            Console.WriteLine("{0}今年{1}岁。", p.Name, p.Age);
            Console.ReadKey();
        }
    }
}
