using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewFeaturesForCSharp3._06_LINQ
{
    class Test
    {
        static void Main(string[] args)
        {
            Product[] products =
            {
                new Product { Name = "西瓜", Category = "水果", Price = 2.3M },
                new Product { Name = "苹果", Category = "水果", Price = 4.9M} ,
                new Product { Name = "空心菜", Category = "蔬菜", Price = 2.2M },
                new Product { Name = "地瓜", Category = "蔬菜", Price = 1.9M }
            };

            // 包含C#对应关键字的LINQ语句
            //var results = from product in products
            //              orderby product.Price descending
            //              select new
            //              {
            //                  product.Name,
            //                  product.Price
            //              };

            // “点号”方式的LINQ查询方式
            var results = products
                .OrderByDescending(e => e.Price)
                .Take(3)
                .Select(e => new { e.Name, e.Price });

            // LINQ延后查询测试
            products[3] = new Product { Name = "榴莲", Category = "水果", Price = 22.6M };

            // 打印价钱最高的三个商品
            //int count = 0;
            foreach (var product in results)
            {
                Console.WriteLine("商品：{0}，价钱：{1}", product.Name, product.Price);
                //if (++count == 3)
                //{
                //    break;
                //}
            }
            Console.ReadKey();
        }
    }
}
