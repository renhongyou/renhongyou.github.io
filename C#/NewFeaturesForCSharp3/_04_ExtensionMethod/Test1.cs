using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NewFeaturesForCSharp3._04_ExtensionMethod
{
    static class Test1
    {
        /// <summary>
        /// 随即返回true或false
        /// </summary>
        /// <param name="random">this参数自动指定到Random的实例</param>
        /// <returns></returns>
        public static bool NextBool(this Random random)
        {
            return random.NextDouble() > 0.5;
        }

        static void Main(string[] args)
        {
            // 调用扩展方法
            Random rd = new Random();
            bool b = rd.NextBool();

            Console.WriteLine(b.ToString());
            Console.ReadKey();
        }
    }
}
