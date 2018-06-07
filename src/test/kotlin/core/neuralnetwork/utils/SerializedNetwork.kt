/* Copyright 2016-present The KotlinNLP Authors. All Rights Reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, you can obtain one at http://mozilla.org/MPL/2.0/.
 * ------------------------------------------------------------------*/

package core.neuralnetwork.utils

/**
 *
 */
object SerializedNetwork {

  val byteArray = byteArrayOf(
    -84, -19, 0, 5, 115, 114, 0, 56, 99, 111, 109, 46, 107, 111, 116, 108, 105, 110, 110, 108,
    112, 46, 115, 105, 109, 112, 108, 101, 100, 110, 110, 46, 99, 111, 114, 101, 46, 110, 101, 117,
    114, 97, 108, 110, 101, 116, 119, 111, 114, 107, 46, 78, 101, 117, 114, 97, 108, 78, 101, 116,
    119, 111, 114, 107, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 7, 73, 0, 9, 105, 110,
    112, 117, 116, 83, 105, 122, 101, 73, 0, 10, 111, 117, 116, 112, 117, 116, 83, 105, 122, 101,
    90, 0, 11, 115, 112, 97, 114, 115, 101, 73, 110, 112, 117, 116, 76, 0, 9, 105, 110, 112,
    117, 116, 84, 121, 112, 101, 116, 0, 53, 76, 99, 111, 109, 47, 107, 111, 116, 108, 105, 110,
    110, 108, 112, 47, 115, 105, 109, 112, 108, 101, 100, 110, 110, 47, 99, 111, 114, 101, 47, 108,
    97, 121, 101, 114, 115, 47, 76, 97, 121, 101, 114, 84, 121, 112, 101, 36, 73, 110, 112, 117,
    116, 59, 76, 0, 10, 105, 110, 112, 117, 116, 115, 83, 105, 122, 101, 116, 0, 16, 76, 106,
    97, 118, 97, 47, 117, 116, 105, 108, 47, 76, 105, 115, 116, 59, 76, 0, 19, 108, 97, 121,
    101, 114, 115, 67, 111, 110, 102, 105, 103, 117, 114, 97, 116, 105, 111, 110, 113, 0, 126, 0,
    2, 76, 0, 5, 109, 111, 100, 101, 108, 116, 0, 62, 76, 99, 111, 109, 47, 107, 111, 116,
    108, 105, 110, 110, 108, 112, 47, 115, 105, 109, 112, 108, 101, 100, 110, 110, 47, 99, 111, 114,
    101, 47, 110, 101, 117, 114, 97, 108, 110, 101, 116, 119, 111, 114, 107, 47, 78, 101, 116, 119,
    111, 114, 107, 80, 97, 114, 97, 109, 101, 116, 101, 114, 115, 59, 120, 112, 0, 0, 0, 3,
    0, 0, 0, 5, 0, 126, 114, 0, 51, 99, 111, 109, 46, 107, 111, 116, 108, 105, 110, 110,
    108, 112, 46, 115, 105, 109, 112, 108, 101, 100, 110, 110, 46, 99, 111, 114, 101, 46, 108, 97,
    121, 101, 114, 115, 46, 76, 97, 121, 101, 114, 84, 121, 112, 101, 36, 73, 110, 112, 117, 116,
    0, 0, 0, 0, 0, 0, 0, 0, 18, 0, 0, 120, 114, 0, 14, 106, 97, 118, 97, 46,
    108, 97, 110, 103, 46, 69, 110, 117, 109, 0, 0, 0, 0, 0, 0, 0, 0, 18, 0, 0,
    120, 112, 116, 0, 5, 68, 101, 110, 115, 101, 115, 114, 0, 35, 106, 97, 118, 97, 46, 117,
    116, 105, 108, 46, 67, 111, 108, 108, 101, 99, 116, 105, 111, 110, 115, 36, 83, 105, 110, 103,
    108, 101, 116, 111, 110, 76, 105, 115, 116, 42, -17, 41, 16, 60, -89, -101, -105, 2, 0, 1,
    76, 0, 7, 101, 108, 101, 109, 101, 110, 116, 116, 0, 18, 76, 106, 97, 118, 97, 47, 108,
    97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 120, 112, 115, 114, 0, 17, 106, 97, 118,
    97, 46, 108, 97, 110, 103, 46, 73, 110, 116, 101, 103, 101, 114, 18, -30, -96, -92, -9, -127,
    -121, 56, 2, 0, 1, 73, 0, 5, 118, 97, 108, 117, 101, 120, 114, 0, 16, 106, 97, 118,
    97, 46, 108, 97, 110, 103, 46, 78, 117, 109, 98, 101, 114, -122, -84, -107, 29, 11, -108, -32,
    -117, 2, 0, 0, 120, 112, 0, 0, 0, 3, 115, 114, 0, 19, 106, 97, 118, 97, 46, 117,
    116, 105, 108, 46, 65, 114, 114, 97, 121, 76, 105, 115, 116, 120, -127, -46, 29, -103, -57, 97,
    -99, 3, 0, 1, 73, 0, 4, 115, 105, 122, 101, 120, 112, 0, 0, 0, 2, 119, 4, 0,
    0, 0, 2, 115, 114, 0, 50, 99, 111, 109, 46, 107, 111, 116, 108, 105, 110, 110, 108, 112,
    46, 115, 105, 109, 112, 108, 101, 100, 110, 110, 46, 99, 111, 114, 101, 46, 108, 97, 121, 101,
    114, 115, 46, 76, 97, 121, 101, 114, 73, 110, 116, 101, 114, 102, 97, 99, 101, 0, 0, 0,
    0, 0, 0, 0, 1, 2, 0, 7, 68, 0, 7, 100, 114, 111, 112, 111, 117, 116, 90, 0,
    6, 109, 101, 80, 114, 111, 112, 73, 0, 4, 115, 105, 122, 101, 76, 0, 18, 97, 99, 116,
    105, 118, 97, 116, 105, 111, 110, 70, 117, 110, 99, 116, 105, 111, 110, 116, 0, 77, 76, 99,
    111, 109, 47, 107, 111, 116, 108, 105, 110, 110, 108, 112, 47, 115, 105, 109, 112, 108, 101, 100,
    110, 110, 47, 99, 111, 114, 101, 47, 102, 117, 110, 99, 116, 105, 111, 110, 97, 108, 105, 116,
    105, 101, 115, 47, 97, 99, 116, 105, 118, 97, 116, 105, 111, 110, 115, 47, 65, 99, 116, 105,
    118, 97, 116, 105, 111, 110, 70, 117, 110, 99, 116, 105, 111, 110, 59, 76, 0, 14, 99, 111,
    110, 110, 101, 99, 116, 105, 111, 110, 84, 121, 112, 101, 116, 0, 58, 76, 99, 111, 109, 47,
    107, 111, 116, 108, 105, 110, 110, 108, 112, 47, 115, 105, 109, 112, 108, 101, 100, 110, 110, 47,
    99, 111, 114, 101, 47, 108, 97, 121, 101, 114, 115, 47, 76, 97, 121, 101, 114, 84, 121, 112,
    101, 36, 67, 111, 110, 110, 101, 99, 116, 105, 111, 110, 59, 76, 0, 5, 115, 105, 122, 101,
    115, 113, 0, 126, 0, 2, 76, 0, 4, 116, 121, 112, 101, 113, 0, 126, 0, 1, 120, 112,
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 112, 112, 113, 0, 126, 0, 11,
    113, 0, 126, 0, 7, 115, 113, 0, 126, 0, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 5, 112, 126, 114, 0, 56, 99, 111, 109, 46, 107, 111, 116, 108, 105, 110, 110,
    108, 112, 46, 115, 105, 109, 112, 108, 101, 100, 110, 110, 46, 99, 111, 114, 101, 46, 108, 97,
    121, 101, 114, 115, 46, 76, 97, 121, 101, 114, 84, 121, 112, 101, 36, 67, 111, 110, 110, 101,
    99, 116, 105, 111, 110, 0, 0, 0, 0, 0, 0, 0, 0, 18, 0, 0, 120, 113, 0, 126,
    0, 6, 116, 0, 11, 70, 101, 101, 100, 102, 111, 114, 119, 97, 114, 100, 115, 113, 0, 126,
    0, 9, 115, 113, 0, 126, 0, 12, 0, 0, 0, 5, 113, 0, 126, 0, 7, 120, 115, 114,
    0, 60, 99, 111, 109, 46, 107, 111, 116, 108, 105, 110, 110, 108, 112, 46, 115, 105, 109, 112,
    108, 101, 100, 110, 110, 46, 99, 111, 114, 101, 46, 110, 101, 117, 114, 97, 108, 110, 101, 116,
    119, 111, 114, 107, 46, 78, 101, 116, 119, 111, 114, 107, 80, 97, 114, 97, 109, 101, 116, 101,
    114, 115, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 5, 90, 0, 10, 102, 111, 114, 99,
    101, 68, 101, 110, 115, 101, 73, 0, 11, 110, 117, 109, 79, 102, 76, 97, 121, 101, 114, 115,
    76, 0, 19, 108, 97, 121, 101, 114, 115, 67, 111, 110, 102, 105, 103, 117, 114, 97, 116, 105,
    111, 110, 113, 0, 126, 0, 2, 76, 0, 10, 112, 97, 114, 97, 109, 115, 76, 105, 115, 116,
    113, 0, 126, 0, 2, 76, 0, 14, 112, 97, 114, 97, 109, 115, 80, 101, 114, 76, 97, 121,
    101, 114, 113, 0, 126, 0, 2, 120, 114, 0, 53, 99, 111, 109, 46, 107, 111, 116, 108, 105,
    110, 110, 108, 112, 46, 115, 105, 109, 112, 108, 101, 100, 110, 110, 46, 99, 111, 114, 101, 46,
    111, 112, 116, 105, 109, 105, 122, 101, 114, 46, 73, 116, 101, 114, 97, 98, 108, 101, 80, 97,
    114, 97, 109, 115, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 120, 112, 1, 0, 0,
    0, 1, 113, 0, 126, 0, 16, 115, 113, 0, 126, 0, 15, 0, 0, 0, 2, 119, 4, 0,
    0, 0, 2, 115, 114, 0, 55, 99, 111, 109, 46, 107, 111, 116, 108, 105, 110, 110, 108, 112,
    46, 115, 105, 109, 112, 108, 101, 100, 110, 110, 46, 99, 111, 114, 101, 46, 97, 114, 114, 97,
    121, 115, 46, 85, 112, 100, 97, 116, 97, 98, 108, 101, 68, 101, 110, 115, 101, 65, 114, 114,
    97, 121, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 1, 76, 0, 6, 118, 97, 108, 117,
    101, 115, 116, 0, 63, 76, 99, 111, 109, 47, 107, 111, 116, 108, 105, 110, 110, 108, 112, 47,
    115, 105, 109, 112, 108, 101, 100, 110, 110, 47, 115, 105, 109, 112, 108, 101, 109, 97, 116, 104,
    47, 110, 100, 97, 114, 114, 97, 121, 47, 100, 101, 110, 115, 101, 47, 68, 101, 110, 115, 101,
    78, 68, 65, 114, 114, 97, 121, 59, 120, 114, 0, 50, 99, 111, 109, 46, 107, 111, 116, 108,
    105, 110, 110, 108, 112, 46, 115, 105, 109, 112, 108, 101, 100, 110, 110, 46, 99, 111, 114, 101,
    46, 97, 114, 114, 97, 121, 115, 46, 85, 112, 100, 97, 116, 97, 98, 108, 101, 65, 114, 114,
    97, 121, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 2, 76, 0, 23, 117, 112, 100, 97,
    116, 101, 114, 83, 117, 112, 112, 111, 114, 116, 83, 116, 114, 117, 99, 116, 117, 114, 101, 116,
    0, 84, 76, 99, 111, 109, 47, 107, 111, 116, 108, 105, 110, 110, 108, 112, 47, 115, 105, 109,
    112, 108, 101, 100, 110, 110, 47, 99, 111, 114, 101, 47, 102, 117, 110, 99, 116, 105, 111, 110,
    97, 108, 105, 116, 105, 101, 115, 47, 117, 112, 100, 97, 116, 101, 109, 101, 116, 104, 111, 100,
    115, 47, 85, 112, 100, 97, 116, 101, 114, 83, 117, 112, 112, 111, 114, 116, 83, 116, 114, 117,
    99, 116, 117, 114, 101, 59, 76, 0, 6, 118, 97, 108, 117, 101, 115, 116, 0, 52, 76, 99,
    111, 109, 47, 107, 111, 116, 108, 105, 110, 110, 108, 112, 47, 115, 105, 109, 112, 108, 101, 100,
    110, 110, 47, 115, 105, 109, 112, 108, 101, 109, 97, 116, 104, 47, 110, 100, 97, 114, 114, 97,
    121, 47, 78, 68, 65, 114, 114, 97, 121, 59, 120, 112, 112, 115, 114, 0, 61, 99, 111, 109,
    46, 107, 111, 116, 108, 105, 110, 110, 108, 112, 46, 115, 105, 109, 112, 108, 101, 100, 110, 110,
    46, 115, 105, 109, 112, 108, 101, 109, 97, 116, 104, 46, 110, 100, 97, 114, 114, 97, 121, 46,
    100, 101, 110, 115, 101, 46, 68, 101, 110, 115, 101, 78, 68, 65, 114, 114, 97, 121, 0, 0,
    0, 0, 0, 0, 0, 1, 2, 0, 2, 76, 0, 7, 102, 97, 99, 116, 111, 114, 121, 116,
    0, 70, 76, 99, 111, 109, 47, 107, 111, 116, 108, 105, 110, 110, 108, 112, 47, 115, 105, 109,
    112, 108, 101, 100, 110, 110, 47, 115, 105, 109, 112, 108, 101, 109, 97, 116, 104, 47, 110, 100,
    97, 114, 114, 97, 121, 47, 100, 101, 110, 115, 101, 47, 68, 101, 110, 115, 101, 78, 68, 65,
    114, 114, 97, 121, 70, 97, 99, 116, 111, 114, 121, 59, 76, 0, 7, 115, 116, 111, 114, 97,
    103, 101, 116, 0, 24, 76, 111, 114, 103, 47, 106, 98, 108, 97, 115, 47, 68, 111, 117, 98,
    108, 101, 77, 97, 116, 114, 105, 120, 59, 120, 112, 115, 114, 0, 68, 99, 111, 109, 46, 107,
    111, 116, 108, 105, 110, 110, 108, 112, 46, 115, 105, 109, 112, 108, 101, 100, 110, 110, 46, 115,
    105, 109, 112, 108, 101, 109, 97, 116, 104, 46, 110, 100, 97, 114, 114, 97, 121, 46, 100, 101,
    110, 115, 101, 46, 68, 101, 110, 115, 101, 78, 68, 65, 114, 114, 97, 121, 70, 97, 99, 116,
    111, 114, 121, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 120, 112, 115, 114, 0, 22,
    111, 114, 103, 46, 106, 98, 108, 97, 115, 46, 68, 111, 117, 98, 108, 101, 77, 97, 116, 114,
    105, 120, -18, -87, -87, 63, 50, 8, 0, 44, 3, 0, 4, 73, 0, 7, 99, 111, 108, 117,
    109, 110, 115, 73, 0, 6, 108, 101, 110, 103, 116, 104, 73, 0, 4, 114, 111, 119, 115, 91,
    0, 4, 100, 97, 116, 97, 116, 0, 2, 91, 68, 120, 112, 0, 0, 0, 3, 0, 0, 0,
    15, 0, 0, 0, 5, 117, 114, 0, 2, 91, 68, 62, -90, -116, 20, -85, 99, 90, 30, 2,
    0, 0, 120, 112, 0, 0, 0, 15, -65, -28, 107, 109, -86, -91, -42, 89, 63, -25, 15, -122,
    -108, 14, 29, -30, -65, -39, -18, -56, -93, -63, 38, 88, -65, -22, 57, -93, -61, -35, 86, 40,
    -65, -37, 55, -123, 55, -13, -78, 108, 63, -49, -103, 10, 4, -95, 37, 112, -65, -23, 61, 25,
    3, 64, -110, -18, 63, -22, 24, -1, 66, 34, 18, 42, -65, -37, 9, -83, -88, -75, 78, 35,
    -65, -32, -30, -15, 13, -3, 81, -93, -65, -24, -100, -50, 66, 10, 115, 50, 63, -21, -112, -57,
    -52, 69, -50, -122, 63, -62, -80, -60, 107, -95, -91, 56, -65, -76, 24, -124, 105, -65, 26, -32,
    63, -53, -114, -31, -5, 106, -11, -8, 120, 113, 0, 126, 0, 40, 115, 113, 0, 126, 0, 31,
    112, 115, 113, 0, 126, 0, 37, 113, 0, 126, 0, 42, 115, 113, 0, 126, 0, 43, 0, 0,
    0, 1, 0, 0, 0, 5, 0, 0, 0, 5, 117, 113, 0, 126, 0, 46, 0, 0, 0, 5,
    -65, -25, -108, 29, 71, 101, 13, 114, 63, -22, -96, -51, -26, -98, -1, 120, -65, -35, -15, -50,
    -94, -99, 86, 44, -65, -18, 72, 62, 78, 116, 115, -28, -65, -33, 109, 102, 72, 60, 124, -48,
    120, 113, 0, 126, 0, 49, 120, 115, 113, 0, 126, 0, 15, 0, 0, 0, 1, 119, 4, 0,
    0, 0, 1, 115, 114, 0, 81, 99, 111, 109, 46, 107, 111, 116, 108, 105, 110, 110, 108, 112,
    46, 115, 105, 109, 112, 108, 101, 100, 110, 110, 46, 99, 111, 114, 101, 46, 108, 97, 121, 101,
    114, 115, 46, 102, 101, 101, 100, 102, 111, 114, 119, 97, 114, 100, 46, 115, 105, 109, 112, 108,
    101, 46, 70, 101, 101, 100, 102, 111, 114, 119, 97, 114, 100, 76, 97, 121, 101, 114, 80, 97,
    114, 97, 109, 101, 116, 101, 114, 115, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 6, 90,
    0, 6, 109, 101, 80, 114, 111, 112, 90, 0, 11, 115, 112, 97, 114, 115, 101, 73, 110, 112,
    117, 116, 76, 0, 10, 98, 105, 97, 115, 101, 115, 76, 105, 115, 116, 113, 0, 126, 0, 2,
    76, 0, 10, 112, 97, 114, 97, 109, 115, 76, 105, 115, 116, 113, 0, 126, 0, 2, 76, 0,
    4, 117, 110, 105, 116, 116, 0, 52, 76, 99, 111, 109, 47, 107, 111, 116, 108, 105, 110, 110,
    108, 112, 47, 115, 105, 109, 112, 108, 101, 100, 110, 110, 47, 99, 111, 114, 101, 47, 108, 97,
    121, 101, 114, 115, 47, 80, 97, 114, 97, 109, 101, 116, 101, 114, 115, 85, 110, 105, 116, 59,
    76, 0, 11, 119, 101, 105, 103, 104, 116, 115, 76, 105, 115, 116, 113, 0, 126, 0, 2, 120,
    114, 0, 51, 99, 111, 109, 46, 107, 111, 116, 108, 105, 110, 110, 108, 112, 46, 115, 105, 109,
    112, 108, 101, 100, 110, 110, 46, 99, 111, 114, 101, 46, 108, 97, 121, 101, 114, 115, 46, 76,
    97, 121, 101, 114, 80, 97, 114, 97, 109, 101, 116, 101, 114, 115, 0, 0, 0, 0, 0, 0,
    0, 1, 2, 0, 4, 73, 0, 9, 105, 110, 112, 117, 116, 83, 105, 122, 101, 73, 0, 10,
    111, 117, 116, 112, 117, 116, 83, 105, 122, 101, 76, 0, 17, 98, 105, 97, 115, 101, 115, 73,
    110, 105, 116, 105, 97, 108, 105, 122, 101, 114, 116, 0, 71, 76, 99, 111, 109, 47, 107, 111,
    116, 108, 105, 110, 110, 108, 112, 47, 115, 105, 109, 112, 108, 101, 100, 110, 110, 47, 99, 111,
    114, 101, 47, 102, 117, 110, 99, 116, 105, 111, 110, 97, 108, 105, 116, 105, 101, 115, 47, 105,
    110, 105, 116, 105, 97, 108, 105, 122, 101, 114, 115, 47, 73, 110, 105, 116, 105, 97, 108, 105,
    122, 101, 114, 59, 76, 0, 18, 119, 101, 105, 103, 104, 116, 115, 73, 110, 105, 116, 105, 97,
    108, 105, 122, 101, 114, 113, 0, 126, 0, 56, 120, 113, 0, 126, 0, 28, 0, 0, 0, 3,
    0, 0, 0, 5, 115, 114, 0, 75, 99, 111, 109, 46, 107, 111, 116, 108, 105, 110, 110, 108,
    112, 46, 115, 105, 109, 112, 108, 101, 100, 110, 110, 46, 99, 111, 114, 101, 46, 102, 117, 110,
    99, 116, 105, 111, 110, 97, 108, 105, 116, 105, 101, 115, 46, 105, 110, 105, 116, 105, 97, 108,
    105, 122, 101, 114, 115, 46, 71, 108, 111, 114, 111, 116, 73, 110, 105, 116, 105, 97, 108, 105,
    122, 101, 114, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 4, 90, 0, 18, 101, 110, 97,
    98, 108, 101, 80, 115, 101, 117, 100, 111, 82, 97, 110, 100, 111, 109, 68, 0, 4, 103, 97,
    105, 110, 74, 0, 4, 115, 101, 101, 100, 76, 0, 13, 115, 101, 101, 100, 71, 101, 110, 101,
    114, 97, 116, 111, 114, 116, 0, 18, 76, 106, 97, 118, 97, 47, 117, 116, 105, 108, 47, 82,
    97, 110, 100, 111, 109, 59, 120, 112, 1, 63, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 2, -25, 115, 114, 0, 16, 106, 97, 118, 97, 46, 117, 116, 105, 108, 46, 82,
    97, 110, 100, 111, 109, 54, 50, -106, 52, 75, -16, 10, 83, 3, 0, 3, 90, 0, 20, 104,
    97, 118, 101, 78, 101, 120, 116, 78, 101, 120, 116, 71, 97, 117, 115, 115, 105, 97, 110, 68,
    0, 16, 110, 101, 120, 116, 78, 101, 120, 116, 71, 97, 117, 115, 115, 105, 97, 110, 74, 0,
    4, 115, 101, 101, 100, 120, 112, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -58, 37,
    0, 5, 7, 84, 120, 115, 113, 0, 126, 0, 58, 1, 63, -16, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 2, -25, 115, 113, 0, 126, 0, 61, 0, 0, 0, 0, 0, 0,
    0, 0, 0, 0, 0, -58, 37, 0, 5, 7, 84, 120, 0, 0, 115, 113, 0, 126, 0, 9,
    113, 0, 126, 0, 48, 115, 114, 0, 26, 106, 97, 118, 97, 46, 117, 116, 105, 108, 46, 65,
    114, 114, 97, 121, 115, 36, 65, 114, 114, 97, 121, 76, 105, 115, 116, -39, -92, 60, -66, -51,
    -120, 6, -46, 2, 0, 1, 91, 0, 1, 97, 116, 0, 19, 91, 76, 106, 97, 118, 97, 47,
    108, 97, 110, 103, 47, 79, 98, 106, 101, 99, 116, 59, 120, 112, 117, 114, 0, 53, 91, 76,
    99, 111, 109, 46, 107, 111, 116, 108, 105, 110, 110, 108, 112, 46, 115, 105, 109, 112, 108, 101,
    100, 110, 110, 46, 99, 111, 114, 101, 46, 97, 114, 114, 97, 121, 115, 46, 85, 112, 100, 97,
    116, 97, 98, 108, 101, 65, 114, 114, 97, 121, 59, 85, -22, 74, 103, -87, -46, -74, -78, 2,
    0, 0, 120, 112, 0, 0, 0, 2, 113, 0, 126, 0, 36, 113, 0, 126, 0, 48, 115, 114,
    0, 50, 99, 111, 109, 46, 107, 111, 116, 108, 105, 110, 110, 108, 112, 46, 115, 105, 109, 112,
    108, 101, 100, 110, 110, 46, 99, 111, 114, 101, 46, 108, 97, 121, 101, 114, 115, 46, 80, 97,
    114, 97, 109, 101, 116, 101, 114, 115, 85, 110, 105, 116, 0, 0, 0, 0, 0, 0, 0, 1,
    2, 0, 6, 73, 0, 9, 105, 110, 112, 117, 116, 83, 105, 122, 101, 90, 0, 6, 109, 101,
    80, 114, 111, 112, 73, 0, 10, 111, 117, 116, 112, 117, 116, 83, 105, 122, 101, 90, 0, 11,
    115, 112, 97, 114, 115, 101, 73, 110, 112, 117, 116, 76, 0, 6, 98, 105, 97, 115, 101, 115,
    116, 0, 52, 76, 99, 111, 109, 47, 107, 111, 116, 108, 105, 110, 110, 108, 112, 47, 115, 105,
    109, 112, 108, 101, 100, 110, 110, 47, 99, 111, 114, 101, 47, 97, 114, 114, 97, 121, 115, 47,
    85, 112, 100, 97, 116, 97, 98, 108, 101, 65, 114, 114, 97, 121, 59, 76, 0, 7, 119, 101,
    105, 103, 104, 116, 115, 113, 0, 126, 0, 72, 120, 112, 0, 0, 0, 3, 0, 0, 0, 0,
    5, 0, 113, 0, 126, 0, 48, 113, 0, 126, 0, 36, 115, 113, 0, 126, 0, 9, 113, 0,
    126, 0, 36, 120
  )
}
