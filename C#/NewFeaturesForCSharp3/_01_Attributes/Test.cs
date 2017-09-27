using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace NewFeaturesForCSharp3._01_Attributes
{
    class Test
    {
        private static bool IsMemberValid(int inputLength, MemberInfo member)
        {
            foreach (object attribute in member.GetCustomAttributes(true))
            {
                if(attribute is MyStringLengthAttribute)
                {
                    MyStringLengthAttribute attr = (MyStringLengthAttribute)attribute;
                    string displayName = attr.DisplayName;
                    int maxLength = attr.MaxLength;
                    int minLength = attr.MinLength;
                    string errorMessage = attr.ErrorMessage;

                    if (inputLength <minLength || inputLength > maxLength)
                    {
                        Console.WriteLine(errorMessage, displayName, minLength, maxLength);

                        return false;
                    }
                    else
                    {
                        return true;
                    }
                }
            }

            return false;
        }

        // 验证是否输入合法
        private static bool IsValid(Order order)
        {
            if (order == null)
            {
                return false;
            }

            foreach (PropertyInfo p in typeof(Order).GetProperties())
            {
                if (IsMemberValid(order.OrderID.Length, p))
                {
                    return true;
                }
            }

            return false;
        }

        public static void Main()
        {
            string input = string.Empty;
            Order order;
            do
            {
                Console.WriteLine("请输入订单号：");
                input = Console.ReadLine();
                order = new Order { OrderID = input };
            }
            while (!IsValid(order));

            Console.WriteLine("订单号输入正确，按任意键退出！");
            Console.ReadKey();
        }
    }
}
